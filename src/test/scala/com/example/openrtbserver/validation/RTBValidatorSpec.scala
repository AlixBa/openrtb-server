package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.model.constant.VideoStartDelays
import com.wix.accord.{ Failure, Result, Success }
import org.scalactic.Pass
import org.scalatest.WordSpec

import scalaz.NonEmptyList

class RTBValidatorSpec extends WordSpec {

  "RTBValidator" when {

    "validating BidRequest" should {

      "accumulates errors" in {
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
        val bidRequestWith23Errors: BidRequest = BidRequest.minimal("id", NonEmptyList(impWith14Errors))
          .copy(site = Option(siteWith1Error), app = Option(appWith0Error), device = Option(deviceWith7errors),
            tmax = Option(-1))

        val impWith1Error: Imp = Imp.minimal("id")
        val bidRequestWith1Error: BidRequest = BidRequest.minimal("id", NonEmptyList(impWith1Error))

        val validators: BidRequestValidator = new BidRequestValidator {}

        val result: Result = RTBValidator.validateBidRequest(validators, bidRequestWith23Errors)
        val result2: Result = RTBValidator.validateBidRequest(validators, bidRequestWith1Error)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.size.equals(23))
        }

        result2 match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.size.equals(1))
        }
      }

      "sends back success if everything is ok" in {
        val videoWith0Error: Video = Video.minimal(Seq())
        val impWith0Error: Imp = Imp.minimal("id").copy(video = Option(videoWith0Error))
        val bidRequestWith0Error: BidRequest = BidRequest.minimal("id", NonEmptyList(impWith0Error))

        val validators: BidRequestValidator = new BidRequestValidator {}
        val result: Result = RTBValidator.validateBidRequest(validators, bidRequestWith0Error)

        result match {
          case Success             ⇒ Pass
          case Failure(violations) ⇒ fail(violations.map(_.constraint).toString())
        }
      }

    }

    "validating BidResponse" should {

      "accumulates errors" in {
        val bidWith3Errors: Bid = Bid.minimal("id", "impid", -1).copy(w = Option(-1), h = Option(-1))
        val seatBidWith3Error: SeatBid = SeatBid.minimal(NonEmptyList(bidWith3Errors))
        val bidResponseWith3Error: BidResponse = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith3Error))

        val validators: BidResponseValidator = new BidResponseValidator {}
        val result: Result = RTBValidator.validateBidResponse(validators, bidResponseWith3Error)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.size.equals(3))
        }
      }

      "sends back success if everything is ok" in {
        val bidWith0Error: Bid = Bid.minimal("id", "impid", 1)
        val seatBidWith0Error: SeatBid = SeatBid.minimal(NonEmptyList(bidWith0Error))
        val bidResponseWith0Error: BidResponse = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith0Error))

        val validators: BidResponseValidator = new BidResponseValidator {}
        val result: Result = RTBValidator.validateBidResponse(validators, bidResponseWith0Error)

        result match {
          case Success             ⇒ Pass
          case Failure(violations) ⇒ fail(violations.map(_.constraint).toString())
        }
      }

    }

  }

}