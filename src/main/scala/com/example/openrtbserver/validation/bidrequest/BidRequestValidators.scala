package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.BidRequest
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object BidRequestValidators {

  object AppOrSite extends Validator[BidRequest] {

    type ObjectName = String
    type ObjectValue = Any

    def apply(bidRequest: BidRequest): Result = {
      val isApp: Boolean = bidRequest.app.isDefined
      val isSite: Boolean = bidRequest.site.isDefined
      val isSiteOrApp: Boolean = (isApp && !isSite) || (isSite && !isApp)
      val isSiteOrAppOrNothing: Boolean = isSiteOrApp || (!isApp && !isSite)

      val value: Map[ObjectName, ObjectValue] = Map("Site" -> bidRequest.site, "App" -> bidRequest.app)
      val constraint: String = "cannot contain both App and Site."

      validate(isSiteOrAppOrNothing, value, constraint, Option("BidRequest"))
    }

  }

  object `tmax` extends Validator[BidRequest] {

    def apply(bidRequest: BidRequest): Result =
      validateEmptyOrPositiveInt(bidRequest.tmax, "BidRequest.tmax")

  }

}