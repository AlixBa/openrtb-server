package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Deal
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object DealValidators {

  object `bidfloor` extends Validator[Deal] {

    def apply(deal: Deal): Result =
      validateEmptyOrPositive(deal, deal.bidfloor, "bidfloor")

  }

}