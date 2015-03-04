package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Deal
import com.wix.accord.Validator
import com.wix.accord.dsl._

object DealValidators {

  val `bidfloor`: Validator[Deal] = validator[Deal] { deal ⇒
    deal.bidfloor.as("Deal.bidfloor").each.should(be >= 0F)
  }

}