package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest.BidRequest
import com.example.openrtbserver.model.bidresponse.BidResponse
import com.wix.accord.{ Result, Success, Validator }

/**
 * The OpenRTBValidator takes care of validating both
 * schema and semantic of BidRequests and BidResponses.
 */
class OpenRTBValidator(validators: Validators) {

  /**
   * Validates an option against some validators.
   * If defined.
   *
   * @tparam A type of the element to validate
   * @param vs the validators
   * @param opt the option to validate
   * @return success or failure
   */
  def validate[A](vs: List[Validator[A]], opt: Option[A]): Result = {
    opt.fold[Result](Success)(validate(vs, _))
  }

  /**
   * Validates an element against some validators.
   *
   * @tparam A type of the element to validate
   * @param vs the validators
   * @param a the element to validate
   * @return success or failure
   */
  def validate[A](vs: List[Validator[A]], a: A): Result = {
    vs.foldLeft[Result](Success) { (r, v) ⇒
      r.and(v(a))
    }
  }

  /**
   * Unreadable validation for a BidRequest.
   *
   * @param bidRequest the BidRequest to validate
   * @return success or failure
   */
  def validate(bidRequest: BidRequest): Result = {
    import validators._

    // TODO: split publisher, content, producer between app and site
    // TODO: make this everywhere it's needed
    validate(bidRequestValidators, bidRequest) // validate BidRequest
      .and(bidRequest.imp.list.foldLeft[Result](Success)({
        (r, imp) ⇒
          r.and(validate(impValidators, imp) // validate imp
            .and(validate(bannerValidators, imp.banner)) // validate banner
            .and(validate(videoValidators, imp.video)) // validate video
            .and(validate(nativeValidators, imp.native)) // validate native
            .and(validate(pmpValidators, imp.pmp)) // validate pmp
            .and(imp.pmp.flatMap(_.deals).foldLeft[Result](Success)({
              (r, deals) ⇒
                r.and(deals.foldLeft[Result](Success)({
                  (r, deal) ⇒ r.and(validate(dealValidators, deal)) // validate deal
                }))
            })))
      }))
      .and(validate(siteValidators, bidRequest.site)) // validate site
      .and(validate(publisherValidators, bidRequest.site.flatMap(_.publisher))) // validate publisher
      .and(validate(contentValidators, bidRequest.site.flatMap(_.content))) // validate content
      .and(validate(producerValidators, bidRequest.site.flatMap(_.content).flatMap(_.producer))) // validate producer
      .and(validate(appValidators, bidRequest.app)) // validate app
      .and(validate(publisherValidators, bidRequest.app.flatMap(_.publisher))) // validate publisher
      .and(validate(contentValidators, bidRequest.app.flatMap(_.content))) // validate content
      .and(validate(producerValidators, bidRequest.app.flatMap(_.content).flatMap(_.producer))) // validate producer
      .and(validate(deviceValidators, bidRequest.device)) // validate device
      .and(validate(geoValidators, bidRequest.device.flatMap(_.geo))) // validate geo
      .and(validate(userValidators, bidRequest.user)) // validate user
      .and(validate(geoValidators, bidRequest.user.flatMap(_.geo))) // validate geo
      .and(bidRequest.user.flatMap(_.data).foldLeft[Result](Success)({
        (r, dataSeq) ⇒
          r.and(dataSeq.foldLeft[Result](Success)({
            (r, data) ⇒
              r.and(validate(dataValidators, data)) // validate dataSeq
                .and(data.segment.foldLeft[Result](Success)({
                  (r, segments) ⇒
                    r.and(segments.foldLeft[Result](Success)({
                      (r, segment) ⇒ r.and(validate(segmentValidators, segment)) // validate segment
                    }))
                }))
          }))
      }))
      .and(validate(regsValidators, bidRequest.regs)) // validate regs
  }

  /**
   * More readable than its brother.
   *
   * @param bidResponse the BidResponse to validate
   * @return success or failure
   */
  def validate(bidResponse: BidResponse): Result = {
    import validators._

    validate(bidResponseValidators, bidResponse)
      .and(bidResponse.seatbid.foldLeft[Result](Success)({
        (r, seatbid) ⇒
          r.and(validate(seatBidValidators, seatbid))
            .and(seatbid.bid.list.foldLeft[Result](Success)({
              (r, bid) ⇒ r.and(validate(bidValidators, bid))
            }))
      }))
  }

}
