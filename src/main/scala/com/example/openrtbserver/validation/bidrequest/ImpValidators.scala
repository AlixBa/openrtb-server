package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Imp
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object ImpValidators {

  object BannerOrVideoOrNative extends Validator[Imp] {

    def apply(impression: Imp): Result = {
      val isBanner: Boolean = impression.banner.isDefined
      val isVideo: Boolean = impression.video.isDefined
      val isNative: Boolean = impression.native.isDefined
      val isBannerOrVideoOrNative: Boolean = isBanner || isVideo || isNative
      val constraint: String = "Impression should contain Banner or Video or App."

      validate(impression, isBannerOrVideoOrNative, constraint)
    }

  }

  object `bidfloor` extends Validator[Imp] {

    def apply(impression: Imp): Result =
      validateEmptyOrPositiveFloat(impression, impression.bidfloor, "bidfloor")

  }

}