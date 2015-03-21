package com.example.openrtbserver.model.context

import com.example.openrtbserver.configuration.ConfigurationAware
import com.example.openrtbserver.conversion.CurrencyConverter
import com.example.openrtbserver.dispatch.OpenRTBClient
import com.example.openrtbserver.model.bidrequest.{ BidRequest, Deal, Imp }
import com.example.openrtbserver.model.bidresponse.{ Bid, BidResponse, SeatBid }
import com.example.openrtbserver.model.types._

/**
 * A contextualized bid is a bid with all context in a easy access.
 * It also provides bid price and mapped floor price in a common currency.
 */
case class ContextualizedBid(converter: CurrencyConverter, client: OpenRTBClient[_, _], bidRequest: BidRequest,
                             bidResponse: BidResponse, seatBid: SeatBid, bid: Bid) extends ConfigurationAware {

  /**
   * Defaults values from configuration.
   */
  val defaultCurrency: Currency = config.getString("openrtbserver.defaults.currency")
  val defaultBidfloor: BidFloor = config.getDouble("openrtbserver.defaults.bidfloor").toFloat

  /**
   * The imp object related to the bid.
   * Will fail on purpose if not found.
   *
   * @throws java.util.NoSuchElementException if the imp is not found
   */
  val imp: Imp =
    bidRequest.imp.list.find(_.id == bid.impid).get

  /**
   * The deal object related to the bid.
   */
  val dealOpt: Option[Deal] = {
    bid.dealid.flatMap { dealid ⇒
      imp.pmp.flatMap { pmp ⇒
        pmp.deals.flatMap { deals ⇒
          deals.find(_.id == dealid)
        }
      }
    }
  }

  /**
   * The bid price for this bid, converted.
   */
  val price: BidPrice = {
    val currency: String = bidResponse.cur.getOrElse(defaultCurrency)

    converter.convert(bid.price, currency, defaultCurrency)
  }

  /**
   * The floor price for this bid, converted.
   */
  val floorPrice: BidFloor = {
    val currency: Currency = dealOpt.flatMap(_.bidfloorcur)
      .orElse(imp.bidfloorcur)
      .getOrElse(defaultCurrency)

    val floorPrice: BidFloor = dealOpt.flatMap(_.bidfloor)
      .orElse(imp.bidfloor)
      .getOrElse(defaultBidfloor)

    converter.convert(floorPrice, currency, defaultCurrency)
  }

}