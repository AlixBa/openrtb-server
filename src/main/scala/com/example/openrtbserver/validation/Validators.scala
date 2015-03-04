package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.validation.bidrequest._
import com.example.openrtbserver.validation.bidresponse.BidValidators
import com.wix.accord.Validator

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

}