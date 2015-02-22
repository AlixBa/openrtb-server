package com.example.openrtbserver.validation.bidresponse

import com.example.openrtbserver.model.bidresponse.Bid
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object BidValidators {

  object `price` extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validate(bid, bid.price >= 0, "price should be positive.")

  }

  object Size extends Validator[Bid] {

    def apply(bid: Bid): Result =
      validateEmptyOrPositive(bid, bid.w, "w")
        .and(validateEmptyOrPositive(bid, bid.h, "h"))

  }

}