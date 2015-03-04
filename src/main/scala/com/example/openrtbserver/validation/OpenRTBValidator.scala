package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse._
import com.wix.accord.{ Result, validate ⇒ wixValidate }

/**
 * The OpenRTBValidator takes care of validating both
 * schema and semantic of BidRequests and BidResponses.
 *
 * @param validators all the validators to use
 */
class OpenRTBValidator(validators: Validators) extends ValidatorsTransformer(validators) {

  /**
   * Validates a BidRequest.
   *
   * @param bidRequest the BidRequest to validate
   * @return success or failure
   */
  def validate(bidRequest: BidRequest): Result =
    wixValidate(bidRequest)(bidRequestValidator)

  /**
   * Validates a BidResponse.
   *
   * @param bidResponse the BidResponse to validate
   * @return success or failure
   */
  def validate(bidResponse: BidResponse): Result =
    wixValidate(bidResponse)(bidResponseValidator)

}