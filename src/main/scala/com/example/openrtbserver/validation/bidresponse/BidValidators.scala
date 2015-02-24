package com.example.openrtbserver.validation.bidresponse

import com.example.openrtbserver.model.bidresponse.Bid
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object BidValidators {

  object `price` extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validateEmptyOrPositiveFloat(bid, Option(bid.price), "price")

  }

  object Size extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validateEmptyOrPositiveInt(bid, bid.w, "w")
        .and(validateEmptyOrPositiveInt(bid, bid.h, "h"))

  }

}