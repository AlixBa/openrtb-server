package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.BidRequest
import com.example.openrtbserver.validation._
import com.wix.accord.{Result, Validator}

object AppOrSite extends Validator[BidRequest] {

  def apply(bidRequest: BidRequest): Result = {
    val isApp: Boolean = bidRequest.app.isDefined
    val isSite: Boolean = bidRequest.site.isDefined
    val isSiteOrApp: Boolean = (isApp && !isSite) || (isSite && !isApp)
    val isSiteOrAppOrNothing: Boolean = isSiteOrApp || (!isApp && !isSite)
    val constraint: String = "BidRequest cannot contain both App and Site."

    validate(bidRequest, isSiteOrAppOrNothing, constraint)
  }

}

object `tmax` extends Validator[BidRequest] {

  def apply(bidRequest: BidRequest): Result =
    validateEmptyOrPositive(bidRequest, bidRequest.tmax, "tmax")

}