package com.example.openrtbserver.validation

import com.example.openrtbserver.conversion.CurrencyConverter
import com.example.openrtbserver.dispatch._
import com.example.openrtbserver.model.bidrequest._
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.model.constant.BooleansAsInt.`true`
import com.example.openrtbserver.model.constant.ContentCategories.`IAB1`
import com.example.openrtbserver.model.constant.VideoStartDelays
import com.example.openrtbserver.model.context.ContextualizedBid
import com.example.openrtbserver.model.types.{ BidPrice, Currency }
import com.wix.accord.{ Failure, Result, Success }
import org.scalactic.Pass
import org.scalatest.WordSpec

import scalaz.{ NonEmptyList, \/, \/- }

class OpenRTBValidatorSpec extends WordSpec {

  import Fixtures._

  "RTBValidator" when {

    "validating BidRequest" should {

      "accumulates errors" in {
        val dealWith1Error = Deal.minimal("id").copy(bidfloor = Option(-1))
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
        val bidRequestWith24Errors = BidRequest.minimal("id", NonEmptyList(impWith14Errors))
          .copy(site = Option(siteWith1Error), app = Option(appWith0Error), device = Option(deviceWith7errors),
            tmax = Option(-1))

        val impWith1Error = Imp.minimal("id")
        val bidRequestWith1Error = BidRequest.minimal("id", NonEmptyList(impWith1Error))

        val result: Result = validator.validate(bidRequestWith24Errors)
        val result2: Result = validator.validate(bidRequestWith1Error)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.flattenAsRuleViolation.size.equals(24))
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
          case Failure(violations) ⇒ fail(violations.flattenAsRuleViolation.toString())
        }
      }

    }

    "validating BidResponse" should {

      "accumulates errors" in {
        val bidWith3Errors = Bid.minimal("id", "impid", -1).copy(w = Option(-1), h = Option(-1))
        val seatBidWith3Errors = SeatBid.minimal(NonEmptyList(bidWith3Errors))
        val bidResponseWith3Errors = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith3Errors))

        val result: Result = validator.validate(bidResponseWith3Errors)

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
          case Failure(violations) ⇒ fail(violations.flattenAsRuleViolation.toString())
        }
      }

    }

    "validating ContextualizedBid" should {

      "accumulates errors" in {
        val dealWith0Error = Deal.minimal("id")
        val pmpWith0Error = Pmp.minimal.copy(private_auction = Option(`true`), deals = Option(Seq(dealWith0Error)))
        val videoWith0Error = Video.minimal(Seq())
        val impWith0Error = Imp.minimal("id").copy(video = Option(videoWith0Error))
          .copy(bidfloor = Option(10), pmp = Option(pmpWith0Error))
        val bidRequestWith0Error = BidRequest.minimal("id", NonEmptyList(impWith0Error)).copy(
          cur = Option(Seq("EUR")), wseat = Option(Seq("allowedSeat")), badv = Option(Seq("blockedAdvertiser")),
          bcat = Option(Seq(`IAB1`))
        )

        val bidWith4Errors = Bid.minimal("id", "id", 1).copy(
          adomain = Option(Seq("blockedAdvertiser")),
          cat = Option(Seq(`IAB1`))
        )
        val seatBidWith5Errors = SeatBid.minimal(NonEmptyList(bidWith4Errors)).copy(seat = Option("seat"))
        val bidResponseWith6Errors = BidResponse.minimal("id").copy(
          seatbid = Seq(seatBidWith5Errors),
          cur = Option("USD")
        )

        val contextualizedBid = ContextualizedBid(converter, client, bidRequestWith0Error, bidResponseWith6Errors,
          seatBidWith5Errors, bidWith4Errors)

        val result: Result = validator.validate(contextualizedBid)

        result match {
          case Success             ⇒ fail("Validation success. It was supposed to fail.")
          case Failure(violations) ⇒ assert(violations.flattenAsRuleViolation.size.equals(6))
        }
      }

      "sends back success if everything is ok" in {
        val videoWith0Error = Video.minimal(Seq())
        val impWith0Error = Imp.minimal("id").copy(video = Option(videoWith0Error)).copy(bidfloor = Option(10))
        val bidRequestWith0Error = BidRequest.minimal("id", NonEmptyList(impWith0Error))

        val bidWith0Error = Bid.minimal("id", "id", 15)
        val seatBidWith0Error = SeatBid.minimal(NonEmptyList(bidWith0Error))
        val bidResponseWith0Error = BidResponse.minimal("id").copy(seatbid = Seq(seatBidWith0Error))

        val contextualizedBid = ContextualizedBid(converter, client, bidRequestWith0Error, bidResponseWith0Error,
          seatBidWith0Error, bidWith0Error)

        val result: Result = validator.validate(contextualizedBid)

        result match {
          case Success             ⇒ Pass
          case Failure(violations) ⇒ fail(violations.flattenAsRuleViolation.toString())
        }
      }

    }

  }

}

object Fixtures {

  val validator = new OpenRTBValidator(new DefaultValidators)

  val converter = new CurrencyConverter {
    def convert(price: BidPrice, from: Currency, to: Currency): BidPrice = price
  }

  val client = new JsonHTTPOpenRTBClient {
    def endpoint: HttpEndpoint = ""

    def method: HttpMethod = ""

    def send(serialized: JsonString): \/[DispatchError, JsonString] = \/-(serialized)

    def deserialize(serialized: JsonString): \/[DispatchError, BidResponse] = \/-(null)

    def serialize(bidRequest: BidRequest): \/[DispatchError, JsonString] = \/-("SerializedBidRequest")
  }

}