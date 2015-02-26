package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, SeatBid, BidResponse }
import com.example.openrtbserver.validation.bidrequest._
import com.example.openrtbserver.validation.bidresponse.BidValidators
import com.wix.accord.Validator

/**
 * All default validators from OpenRTB.
 */
class Validators {

  /**
   * BidRequest part.
   */

  def bidRequestValidators: List[Validator[BidRequest]] =
    List(BidRequestValidators.AppOrSite, BidRequestValidators.`tmax`)

  def impValidators: List[Validator[Imp]] =
    List(ImpValidators.BannerOrVideoOrNative, ImpValidators.`bidfloor`)

  def bannerValidators: List[Validator[Banner]] =
    List(BannerValidators.Size, BannerValidators.MaxSize, BannerValidators.MinSize)

  def videoValidators: List[Validator[Video]] =
    List(VideoValidators.Duration, VideoValidators.Size, VideoValidators.BitRate)

  def nativeValidators: List[Validator[Native]] = List.empty

  def siteValidators: List[Validator[Site]] = List.empty

  def appValidators: List[Validator[App]] = List.empty

  def publisherValidators: List[Validator[Publisher]] = List.empty

  def contentValidators: List[Validator[Content]] =
    List(ContentValidators.`len`)

  def producerValidators: List[Validator[Producer]] = List.empty

  def deviceValidators: List[Validator[Device]] =
    List(DeviceValidators.`ipv4`, DeviceValidators.`ipv6`, DeviceValidators.Size, DeviceValidators.`ppi`)

  def geoValidators: List[Validator[Geo]] =
    List(GeoValidators.`lat`, GeoValidators.`lon`)

  def userValidators: List[Validator[User]] = List.empty

  def dataValidators: List[Validator[Data]] = List.empty

  def segmentValidators: List[Validator[Segment]] = List.empty

  def regsValidators: List[Validator[Regs]] = List.empty

  def pmpValidators: List[Validator[Pmp]] = List.empty

  def dealValidators: List[Validator[Deal]] =
    List(DealValidators.`bidfloor`)

  /**
   * BidResponse part.
   */

  def bidResponseValidators: List[Validator[BidResponse]] = List.empty

  def seatBidValidators: List[Validator[SeatBid]] = List.empty

  def bidValidators: List[Validator[Bid]] =
    List(BidValidators.`price`, BidValidators.Size)

}