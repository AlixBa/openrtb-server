package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.validation.bidrequest._
import com.example.openrtbserver.validation.bidresponse.BidValidators
import com.wix.accord.Validator
import com.wix.accord.combinators.And
import com.wix.accord.dsl._

/**
 * All default validators from OpenRTB.
 *
 * TODO: split publisher, content, producer between app and site
 * TODO: make this everywhere it's needed
 */
class Validators {

  /**
   * BidRequest part.
   */

  def bidRequestValidators: List[Validator[BidRequest]] =
    List(BidRequestValidators.appOrSite, BidRequestValidators.`tmax`)

  def impValidators: List[Validator[Imp]] =
    List(ImpValidators.bannerOrVideoOrNative, ImpValidators.`bidfloor`)

  def bannerValidators: List[Validator[Banner]] =
    List(BannerValidators.size, BannerValidators.maxSize, BannerValidators.minSize)

  def videoValidators: List[Validator[Video]] =
    List(VideoValidators.duration, VideoValidators.size, VideoValidators.bitRate)

  def nativeValidators: List[Validator[Native]] = List.empty

  def pmpValidators: List[Validator[Pmp]] = List.empty

  def dealValidators: List[Validator[Deal]] =
    List(DealValidators.`bidfloor`)

  def siteValidators: List[Validator[Site]] = List.empty

  def appValidators: List[Validator[App]] = List.empty

  def publisherValidators: List[Validator[Publisher]] = List.empty

  def contentValidators: List[Validator[Content]] =
    List(ContentValidators.`len`)

  def producerValidators: List[Validator[Producer]] = List.empty

  def deviceValidators: List[Validator[Device]] =
    List(DeviceValidators.`ipv4`, DeviceValidators.`ipv6`, DeviceValidators.size, DeviceValidators.`ppi`)

  def geoValidators: List[Validator[Geo]] =
    List(GeoValidators.latitude, GeoValidators.longitude)

  def userValidators: List[Validator[User]] = List.empty

  def dataValidators: List[Validator[Data]] = List.empty

  def segmentValidators: List[Validator[Segment]] = List.empty

  def regsValidators: List[Validator[Regs]] = List.empty

  /**
   * BidResponse part.
   */

  def bidResponseValidators: List[Validator[BidResponse]] = List.empty

  def seatBidValidators: List[Validator[SeatBid]] = List.empty

  def bidValidators: List[Validator[Bid]] =
    List(BidValidators.`price`, BidValidators.size)

  /**
   * Implicit for validations.
   * Used to make above def simpler.
   */

  implicit val regsValidator = validator[Regs] { regs ⇒
    regs.is(valid(new And(regsValidators: _*)))
  }

  implicit val segmentValidator = validator[Segment] { segment ⇒
    segment.is(valid(new And(segmentValidators: _*)))
  }

  implicit val dataValidator = validator[Data] { data ⇒
    data.is(valid(new And(dataValidators: _*)))
    data.segment.each.each.is(valid)
  }

  implicit val geoValidator = validator[Geo] { geo ⇒
    geo.is(valid(new And(geoValidators: _*)))
  }

  implicit val userValidator = validator[User] { user ⇒
    user.is(valid(new And(userValidators: _*)))
    user.geo.each.is(valid)
    user.data.each.each.is(valid)
  }

  implicit val deviceValidator = validator[Device] { device ⇒
    device.is(valid(new And(deviceValidators: _*)))
    device.geo.each.is(valid)
  }

  implicit val producerValidator = validator[Producer] { producer ⇒
    producer.is(valid(new And(producerValidators: _*)))
  }

  implicit val contentValidator = validator[Content] { content ⇒
    content.is(valid(new And(contentValidators: _*)))
    content.producer.each.is(valid)
  }

  implicit val publisherValidator = validator[Publisher] { publisher ⇒
    publisher.is(valid(new And(publisherValidators: _*)))
  }

  implicit val appValidator = validator[App] { app ⇒
    app.is(valid(new And(appValidators: _*)))
    app.publisher.each.is(valid)
    app.content.each.is(valid)
  }

  implicit val siteValidator = validator[Site] { site ⇒
    site.is(valid(new And(siteValidators: _*)))
    site.publisher.each.is(valid)
    site.content.each.is(valid)
  }

  implicit val dealValidator = validator[Deal] { deal ⇒
    deal.is(valid(new And(dealValidators: _*)))
  }

  implicit val pmpValidator = validator[Pmp] { pmp ⇒
    pmp.is(valid(new And(pmpValidators: _*)))
    pmp.deals.each.each.is(valid)
  }

  implicit val bannerValidator = validator[Banner] { banner ⇒
    banner.is(valid(new And(bannerValidators: _*)))
  }

  implicit val videoValidator = validator[Video] { video ⇒
    video.is(valid(new And(videoValidators: _*)))
    video.companionad.each.each.is(valid)
  }

  implicit val nativeValidator = validator[Native] { native ⇒
    native.is(valid(new And(nativeValidators: _*)))
  }

  implicit val impValidator = validator[Imp] { imp ⇒
    imp.is(valid(new And(impValidators: _*)))
    imp.banner.each.is(valid)
    imp.video.each.is(valid)
    imp.native.each.is(valid)
    imp.pmp.each.is(valid)
  }

  implicit val bidRequestValidator = validator[BidRequest] { bidRequest ⇒
    bidRequest.is(valid(new And(bidRequestValidators: _*)))
    bidRequest.imp.list.each.is(valid)
    bidRequest.site.each.is(valid)
    bidRequest.app.each.is(valid)
    bidRequest.device.each.is(valid)
    bidRequest.user.each.is(valid)
    bidRequest.regs.each.is(valid)
  }

  implicit val bidValidator = validator[Bid] { bid ⇒
    bid.is(valid(new And(bidValidators: _*)))
  }

  implicit val seatBidValidator = validator[SeatBid] { seatBid ⇒
    seatBid.is(valid(new And(seatBidValidators: _*)))
    seatBid.bid.list.each.is(valid)
  }

  implicit val bidResponseValidator = validator[BidResponse] { bidResponse ⇒
    bidResponse.is(valid(new And(bidResponseValidators: _*)))
    bidResponse.seatbid.each.is(valid)
  }

}