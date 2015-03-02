package com.example.openrtbserver.validation

import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.model.constant.VideoStartDelays
import com.wix.accord.{ Failure, Result, Success }
import org.scalactic.Pass
import org.scalatest.WordSpec

import scalaz.NonEmptyList

class OpenRTBValidatorSpec extends WordSpec {

  import Fixtures._

  "RTBValidator" when {

    "validating BidRequest" should {

      "accumulates errors" in {
        val dealWith1Error = Deal.minimal("id")
        val pmpWith1Error = Pmp.minimal.copy(deals = Option(Seq(dealWith1Error)))
        val videoWith6Errors = Video.recommended(Seq(), -1, -1, Seq(), -1, -1, VideoStartDelays.PreRoll)
          .copy(minbitrate = Option(-1), maxbitrate = Option(-1))
        val bannerWith6Errors = Banner.recommended(-1, -1)
          .copy(wmax = Option(-1), hmax = Option(-1), wmin = Option(-1), hmin = Option(-1))
        val impWith14Errors = Imp.minimal("id")
          .copy(bidfloor = Option(-1), banner = Option(bannerWith6Errors),
            video = Option(videoWith6Errors), pmp = Option(pmpWith1Error))
        val geoWith2Errors = Geo.minimal.copy(lat = Option(-1000), lon = Option(-1000))
        val deviceWith7errors = Device.minimal.copy(ip = Option("0"), ipv6 = Option("0"),
          w = Option(-1), h = Option(-1), ppi = Option(-1), geo = Option(geoWith2Errors))
        val contentWith1Error = Content.minimal.copy(len = Option(-1))
        val siteWith1Error = Site.minimal.copy(content = Option(contentWith1Error))
        val appWith0Error = App.minimal
        val bidRequestWith23Errors = BidRequest.minimal("id", NonEmptyList(impWith14Errors))
          .copy(site = Option(siteWith1Error), app = Option(appWith0Error), device = Option(deviceWith7errors),
            tmax = Option(-1))

        val impWith1Error = Imp.minimal("id")
        val bidRequestWith1Error = BidRequest.minimal("id", NonEmptyList(impWith1Error))

        val result: Result = validator.validate(bidRequestWith23Errors)
        val result2: Result = validator.validate(bidRequestWith1Error)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.flattenAsRuleViolation.size.equals(23))
        }

        result2 match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.flattenAsRuleViolation.size.equals(1))
        }
      }

      "sends back success if everything is ok" in {
        val videoWith0Error = Video.minimal(Seq())
        val impWith0Error = Imp.minimal("id").copy(video = Option(videoWith0Error))
        val bidRequestWith0Error = BidRequest.minimal("id", NonEmptyList(impWith0Error))

        val result: Result = validator.validate(bidRequestWith0Error)

        result match {
          case Success             ⇒ Pass
          case Failure(violations) ⇒ fail(violations.map(_.constraint).toString())
        }
      }

    }

    "validating BidResponse" should {

      "accumulates errors" in {
        val bidWith3Errors = Bid.minimal("id", "impid", -1).copy(w = Option(-1), h = Option(-1))
        val seatBidWith3Error = SeatBid.minimal(NonEmptyList(bidWith3Errors))
        val bidResponseWith3Error = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith3Error))

        val result: Result = validator.validate(bidResponseWith3Error)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.flattenAsRuleViolation.size.equals(3))
        }
      }

      "sends back success if everything is ok" in {
        val bidWith0Error = Bid.minimal("id", "impid", 1)
        val seatBidWith0Error = SeatBid.minimal(NonEmptyList(bidWith0Error))
        val bidResponseWith0Error = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith0Error))

        val result: Result = validator.validate(bidResponseWith0Error)

        result match {
          case Success             ⇒ Pass
          case Failure(violations) ⇒ fail(violations.map(_.constraint).toString())
        }
      }

    }

  }

}

object Fixtures {

  val validator = new OpenRTBValidator(new Validators)

}