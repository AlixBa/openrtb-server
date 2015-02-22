package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Banner
import com.example.openrtbserver.validation._
import com.wix.accord.{Result, Validator}

object BSize extends Validator[Banner] {

  def apply(banner: Banner): Result =
    validateEmptyOrPositive(banner, banner.w, "w")
      .and(validateEmptyOrPositive(banner, banner.h, "h"))

}

object MaxSize extends Validator[Banner] {

  def apply(banner: Banner): Result =
    validateEmptyOrPositive(banner, banner.wmax, "wmax")
      .and(validateEmptyOrPositive(banner, banner.hmax, "hmax"))

}

object MinSize extends Validator[Banner] {

  def apply(banner: Banner): Result =
    validateEmptyOrPositive(banner, banner.wmin, "wmin")
      .and(validateEmptyOrPositive(banner, banner.hmin, "hmin"))

}