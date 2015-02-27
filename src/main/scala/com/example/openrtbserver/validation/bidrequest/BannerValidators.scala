package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Banner
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }
import com.wix.accord.dsl._

object BannerValidators {

  object Size extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner.w, "Banner.w")
        .and(validateEmptyOrPositiveInt(banner.h, "Banner.h"))

  }

  object MaxSize extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner.wmax, "Banner.wmax")
        .and(validateEmptyOrPositiveInt(banner.hmax, "Banner.hmax"))

  }

  object MinSize extends Validator[Banner] {

    def apply(banner: Banner): Result =
      validateEmptyOrPositiveInt(banner.wmin, "Banner.wmin")
        .and(validateEmptyOrPositiveInt(banner.hmin, "Banner.hmin"))

  }

}