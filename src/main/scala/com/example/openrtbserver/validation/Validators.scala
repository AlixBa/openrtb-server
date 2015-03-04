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

  def bidRequestValidators: Seq[Validator[BidRequest]] =
    List(BidRequestValidators.appOrSite, BidRequestValidators.`tmax`)

  def impValidators: Seq[Validator[Imp]] =
    List(ImpValidators.bannerOrVideoOrNative, ImpValidators.`bidfloor`)

  def bannerValidators: Seq[Validator[Banner]] =
    List(BannerValidators.size, BannerValidators.maxSize, BannerValidators.minSize)

  def videoValidators: Seq[Validator[Video]] =
    List(VideoValidators.duration, VideoValidators.size, VideoValidators.bitRate)

  def nativeValidators: Seq[Validator[Native]] = List.empty

  def pmpValidators: Seq[Validator[Pmp]] = List.empty

  def dealValidators: Seq[Validator[Deal]] =
    List(DealValidators.`bidfloor`)

  def siteValidators: Seq[Validator[Site]] = List.empty

  def appValidators: Seq[Validator[App]] = List.empty

  def publisherValidators: Seq[Validator[Publisher]] = List.empty

  def contentValidators: Seq[Validator[Content]] =
    List(ContentValidators.`len`)

  def producerValidators: Seq[Validator[Producer]] = List.empty

  def deviceValidators: Seq[Validator[Device]] =
    List(DeviceValidators.`ipv4`, DeviceValidators.`ipv6`, DeviceValidators.size, DeviceValidators.`ppi`)

  def geoValidators: Seq[Validator[Geo]] =
    List(GeoValidators.latitude, GeoValidators.longitude)

  def userValidators: Seq[Validator[User]] = List.empty

  def dataValidators: Seq[Validator[Data]] = List.empty

  def segmentValidators: Seq[Validator[Segment]] = List.empty

  def regsValidators: Seq[Validator[Regs]] = List.empty

  /**
   * BidResponse part.
   */

  def bidResponseValidators: Seq[Validator[BidResponse]] = List.empty

  def seatBidValidators: Seq[Validator[SeatBid]] = List.empty

  def bidValidators: Seq[Validator[Bid]] =
    List(BidValidators.`price`, BidValidators.size)

}