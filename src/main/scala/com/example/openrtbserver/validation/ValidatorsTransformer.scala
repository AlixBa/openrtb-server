package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.wix.accord.Validator
import com.wix.accord.combinators.And
import com.wix.accord.dsl._

/**
 * Transforms lists of validators from Validators
 * into a single validator for every OpenRTB model.
 * It introduces hierarchy validation among these models.
 *
 * @param validators the validators to transform
 */
class ValidatorsTransformer(validators: Validators) {

  import validators._

  val regsValidator: Validator[Regs] = validator[Regs] { regs ⇒
    regs.is(valid(new And(regsValidators: _*)))
  }

  val segmentValidator: Validator[Segment] = validator[Segment] { segment ⇒
    segment.is(valid(new And(segmentValidators: _*)))
  }

  val dataValidator: Validator[Data] = validator[Data] { data ⇒
    data.is(valid(new And(dataValidators: _*)))
    data.segment.each.each.is(valid(segmentValidator))
  }

  val geoValidator: Validator[Geo] = validator[Geo] { geo ⇒
    geo.is(valid(new And(geoValidators: _*)))
  }

  val userValidator: Validator[User] = validator[User] { user ⇒
    user.is(valid(new And(userValidators: _*)))
    user.geo.each.is(valid(geoValidator))
    user.data.each.each.is(valid(dataValidator))
  }

  val deviceValidator: Validator[Device] = validator[Device] { device ⇒
    device.is(valid(new And(deviceValidators: _*)))
    device.geo.each.is(valid(geoValidator))
  }

  val producerValidator: Validator[Producer] = validator[Producer] { producer ⇒
    producer.is(valid(new And(producerValidators: _*)))
  }

  val contentValidator: Validator[Content] = validator[Content] { content ⇒
    content.is(valid(new And(contentValidators: _*)))
    content.producer.each.is(valid(producerValidator))
  }

  val publisherValidator: Validator[Publisher] = validator[Publisher] { publisher ⇒
    publisher.is(valid(new And(publisherValidators: _*)))
  }

  val appValidator: Validator[App] = validator[App] { app ⇒
    app.is(valid(new And(appValidators: _*)))
    app.publisher.each.is(valid(publisherValidator))
    app.content.each.is(valid(contentValidator))
  }

  val siteValidator: Validator[Site] = validator[Site] { site ⇒
    site.is(valid(new And(siteValidators: _*)))
    site.publisher.each.is(valid(publisherValidator))
    site.content.each.is(valid(contentValidator))
  }

  val dealValidator: Validator[Deal] = validator[Deal] { deal ⇒
    deal.is(valid(new And(dealValidators: _*)))
  }

  val pmpValidator: Validator[Pmp] = validator[Pmp] { pmp ⇒
    pmp.is(valid(new And(pmpValidators: _*)))
    pmp.deals.each.each.is(valid(dealValidator))
  }

  val bannerValidator: Validator[Banner] = validator[Banner] { banner ⇒
    banner.is(valid(new And(bannerValidators: _*)))
  }

  val videoValidator: Validator[Video] = validator[Video] { video ⇒
    video.is(valid(new And(videoValidators: _*)))
    video.companionad.each.each.is(valid(bannerValidator))
  }

  val nativeValidator: Validator[Native] = validator[Native] { native ⇒
    native.is(valid(new And(nativeValidators: _*)))
  }

  val impValidator: Validator[Imp] = validator[Imp] { imp ⇒
    imp.is(valid(new And(impValidators: _*)))
    imp.banner.each.is(valid(bannerValidator))
    imp.video.each.is(valid(videoValidator))
    imp.native.each.is(valid(nativeValidator))
    imp.pmp.each.is(valid(pmpValidator))
  }

  val bidRequestValidator: Validator[BidRequest] = validator[BidRequest] { bidRequest ⇒
    bidRequest.is(valid(new And(bidRequestValidators: _*)))
    bidRequest.imp.list.each.is(valid(impValidator))
    bidRequest.site.each.is(valid(siteValidator))
    bidRequest.app.each.is(valid(appValidator))
    bidRequest.device.each.is(valid(deviceValidator))
    bidRequest.user.each.is(valid(userValidator))
    bidRequest.regs.each.is(valid(regsValidator))
  }

  val bidValidator: Validator[Bid] = validator[Bid] { bid ⇒
    bid.is(valid(new And(bidValidators: _*)))
  }

  val seatBidValidator: Validator[SeatBid] = validator[SeatBid] { seatBid ⇒
    seatBid.is(valid(new And(seatBidValidators: _*)))
    seatBid.bid.list.each.is(valid(bidValidator))
  }

  val bidResponseValidator: Validator[BidResponse] = validator[BidResponse] { bidResponse ⇒
    bidResponse.is(valid(new And(bidResponseValidators: _*)))
    bidResponse.seatbid.each.is(valid(seatBidValidator))
  }
}