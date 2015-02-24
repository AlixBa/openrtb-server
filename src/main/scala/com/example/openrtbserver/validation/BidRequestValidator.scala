package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.validation.bidrequest._
import com.wix.accord.Validator

/**
 * Trait for all the validations done on a
 * BidRequest level.
 */
trait BidRequestValidator {

  def bidRequestValidators: List[Validator[BidRequest]] =
    List(BidRequestValidators.AppOrSite, BidRequestValidators.`tmax`)

  def impValidators: List[Validator[Imp]] =
    List(ImpValidators.BannerOrVideoOrNative, ImpValidators.`bidfloor`)

  def bannerValidators: List[Validator[Banner]] =
    List(BannerValidators.Size, BannerValidators.MaxSize, BannerValidators.MinSize)

  def videoValidators: List[Validator[Video]] =
    List(VideoValidators.Duration, VideoValidators.Size, VideoValidators.BitRate)

  def nativeValidators: List[Validator[Native]] = List()

  def siteValidators: List[Validator[Site]] = List()

  def appValidators: List[Validator[App]] = List()

  def publisherValidators: List[Validator[Publisher]] = List()

  def contentValidators: List[Validator[Content]] =
    List(ContentValidators.`len`)

  def producerValidators: List[Validator[Producer]] = List()

  def deviceValidators: List[Validator[Device]] =
    List(DeviceValidators.`ipv4`, DeviceValidators.`ipv6`, DeviceValidators.Size, DeviceValidators.`ppi`)

  def geoValidators: List[Validator[Geo]] =
    List(GeoValidators.`lat`, GeoValidators.`lon`)

  def userValidators: List[Validator[User]] = List()

  def dataValidators: List[Validator[Data]] = List()

  def segmentValidators: List[Validator[Segment]] = List()

  def regsValidators: List[Validator[Regs]] = List()

  def pmpValidators: List[Validator[Pmp]] = List()

  def dealValidators: List[Validator[Deal]] =
    List(DealValidators.`bidfloor`)

}