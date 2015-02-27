package com.example.openrtbserver.validation.bidresponse

import com.example.openrtbserver.model.bidresponse.Bid
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object BidValidators {

  object `price` extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validateEmptyOrPositiveFloat(Option(bid.price), "Bid.price")

  }

  object Size extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validateEmptyOrPositiveInt(bid.w, "Bid.w")
        .and(validateEmptyOrPositiveInt(bid.h, "Bid.h"))

  }

}