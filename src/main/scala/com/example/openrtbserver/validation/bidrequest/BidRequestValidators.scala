package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.BidRequest
import com.wix.accord.ViolationBuilder.result
import com.wix.accord.dsl._
import com.wix.accord.{ Result, RuleViolation, Validator }

object BidRequestValidators {

  val appOrSite = new Validator[BidRequest] {

    def apply(bidRequest: BidRequest): Result = {
      val isApp = bidRequest.app.isDefined
      val isSite = bidRequest.site.isDefined
      val isSiteOrAppOrNothing =
        (isApp && !isSite) || (isSite && !isApp) || (!isApp && !isSite)

      val value = Map("Site" -> bidRequest.site, "App" -> bidRequest.app)
      val constraint = "cannot contain both App and Site"
      val description = Option("BidRequest")

      result(isSiteOrAppOrNothing, RuleViolation(value, constraint, description))
    }

  }

  val `tmax`: Validator[BidRequest] = validator[BidRequest] { bidRequest ⇒
    bidRequest.tmax.as("BidRequest.tmax").each.should(be >= 0)
  }

}