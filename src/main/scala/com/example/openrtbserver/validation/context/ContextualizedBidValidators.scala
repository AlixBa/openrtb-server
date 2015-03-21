package com.example.openrtbserver.validation.context

import com.example.openrtbserver.model.constant.BooleansAsInt.`true`
import com.example.openrtbserver.model.constant.ContentCategory
import com.example.openrtbserver.model.context.ContextualizedBid
import com.wix.accord.ViolationBuilder._
import com.wix.accord.dsl._
import com.wix.accord.{ Result, RuleViolation, Validator }

object ContextualizedBidValidators {

  type CB = ContextualizedBid

  val `cur` = new Validator[CB] {

    def apply(contextualizedBid: CB): Result = {
      val currencyOpt: Option[String] = contextualizedBid.bidResponse.cur
      val allowedCurrenciesOpt: Option[Seq[String]] = contextualizedBid.bidRequest.cur

      val isCurrencyAllowed =
        allowedCurrenciesOpt.forall(allowedCurrencies ⇒
          currencyOpt.exists(allowedCurrencies.contains))

      val value = Map("allowed" -> allowedCurrenciesOpt, "found" -> currencyOpt)
      val constraint = "is not allowed"
      val description = Option("cur")

      result(isCurrencyAllowed, RuleViolation(value, constraint, description))
    }

  }

  val `seat` = new Validator[CB] {

    def apply(contextualizedBid: CB): Result = {
      val seatOpt: Option[String] = contextualizedBid.seatBid.seat
      val allowedSeatsOpt: Option[Seq[String]] =
        contextualizedBid.bidRequest.wseat
          .orElse(contextualizedBid.dealOpt.flatMap(_.wseat))

      val isSeatAllowed =
        allowedSeatsOpt.forall(allowedSeats ⇒
          seatOpt.exists(allowedSeats.contains))

      val value = Map("allowed" -> allowedSeatsOpt, "found" -> seatOpt)
      val constraint = "is not allowed"
      val description = Option("seat")

      result(isSeatAllowed, RuleViolation(value, constraint, description))
    }

  }

  val `adomain` = new Validator[CB] {

    def apply(contextualizedBid: CB): Result = {
      val advertisersOpt: Option[Seq[String]] = contextualizedBid.bid.adomain
      val blockedAdvertisersOpt: Option[Seq[String]] =
        contextualizedBid.dealOpt.flatMap(_.wadomain)
          .orElse(contextualizedBid.bidRequest.badv)

      val areAdvertisersAllowed =
        blockedAdvertisersOpt.forall(blockedAdvertisers ⇒
          !advertisersOpt.exists(advertisers ⇒
            advertisers.exists(blockedAdvertisers.contains)))

      val value = Map("blocked" -> blockedAdvertisersOpt, "found" -> advertisersOpt)
      val constraint = "is not allowed"
      val description = Option("adomain")

      result(areAdvertisersAllowed, RuleViolation(value, constraint, description))
    }

  }

  val `cat` = new Validator[CB] {

    def apply(contextualizedBid: CB): Result = {
      val categoriesOpt: Option[Seq[ContentCategory]] = contextualizedBid.bid.cat
      val blockedCategoriesOpt: Option[Seq[ContentCategory]] = contextualizedBid.bidRequest.bcat

      val areCategoriesAllowed =
        blockedCategoriesOpt.forall(blockedAdvertisers ⇒
          !categoriesOpt.exists(advertisers ⇒
            advertisers.exists(blockedAdvertisers.contains)))

      val value = Map("blocked" -> blockedCategoriesOpt, "found" -> categoriesOpt)
      val constraint = "is not allowed"
      val description = Option("cat")

      result(areCategoriesAllowed, RuleViolation(value, constraint, description))
    }

  }

  val auction = new Validator[CB] {

    def apply(contextualizedBid: CB): Result = {
      val isDealDefined = contextualizedBid.dealOpt.isDefined
      val isPrivateAuction =
        contextualizedBid.imp.pmp.exists(_.private_auction.contains(`true`))
      val isPublicAuction = !isPrivateAuction

      val isPublicOrPrivateWithDeal = isPublicAuction || (isPrivateAuction && isDealDefined)

      val value = Map(
        "allowed" -> contextualizedBid.imp.pmp.flatMap(_.deals.map(_.map(_.id))).getOrElse(Seq()),
        "found" -> contextualizedBid.bid.dealid
      )
      val constraint = "is not allowed"
      val description = Option("private_auction")

      result(isPublicOrPrivateWithDeal, RuleViolation(value, constraint, description))
    }

  }

  val `price`: Validator[CB] = validator[CB] { contextualizedBid ⇒
    contextualizedBid.price.as("Bid.price").should(be >= contextualizedBid.floorPrice)
  }

}
