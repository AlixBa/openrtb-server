package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Banner
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object BannerValidators {

  object Size extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner, banner.w, "w")
        .and(validateEmptyOrPositiveInt(banner, banner.h, "h"))

  }

  object MaxSize extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner, banner.wmax, "wmax")
        .and(validateEmptyOrPositiveInt(banner, banner.hmax, "hmax"))

  }

  object MinSize extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner, banner.wmin, "wmin")
        .and(validateEmptyOrPositiveInt(banner, banner.hmin, "hmin"))

  }

}