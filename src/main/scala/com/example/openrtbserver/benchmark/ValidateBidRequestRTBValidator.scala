package com.example.openrtbserver.benchmark

import java.util.concurrent.TimeUnit

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.constant.VideoStartDelays
import com.example.openrtbserver.validation.{ BidRequestValidator, RTBValidator }
import com.wix.accord.Result
import org.openjdk.jmh.annotations._

import scalaz.NonEmptyList

@State(Scope.Thread)
class ValidateBidRequestRTBValidator {

  var bidRequest: BidRequest = _
  val validators: BidRequestValidator = new BidRequestValidator {}

  @Setup(Level.Iteration)
  def fixtures(): Unit = {
    val dealWith1Error: Deal = Deal.minimal("id")
    val pmpWith1Error: Pmp = Pmp.minimal.copy(deals = Option(Seq(dealWith1Error)))
    val videoWith6Errors: Video = Video.recommended(Seq(), -1, -1, Seq(), -1, -1, VideoStartDelays.PreRoll)
      .copy(minbitrate = Option(-1), maxbitrate = Option(-1))
    val bannerWith6Errors: Banner = Banner.recommended(-1, -1)
      .copy(wmax = Option(-1), hmax = Option(-1), wmin = Option(-1), hmin = Option(-1))
    val impWith14Errors: Imp = Imp.minimal("id")
      .copy(bidfloor = Option(-1), banner = Option(bannerWith6Errors),
        video = Option(videoWith6Errors), pmp = Option(pmpWith1Error))
    val geoWith2Errors: Geo = Geo.minimal.copy(lat = Option(-1000), lon = Option(-1000))
    val deviceWith7errors: Device = Device.minimal.copy(ip = Option("0"), ipv6 = Option("0"),
      w = Option(-1), h = Option(-1), ppi = Option(-1), geo = Option(geoWith2Errors))
    val contentWith1Error: Content = Content.minimal.copy(len = Option(-1))
    val siteWith1Error: Site = Site.minimal.copy(content = Option(contentWith1Error))
    val appWith0Error: App = App.minimal
    bidRequest = BidRequest.minimal("id", NonEmptyList(impWith14Errors))
      .copy(site = Option(siteWith1Error), app = Option(appWith0Error), device = Option(deviceWith7errors),
        tmax = Option(-1))
  }

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput, Mode.AverageTime))
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  def validate: Result = {
    RTBValidator.validateBidRequest(validators, bidRequest)
  }

}
