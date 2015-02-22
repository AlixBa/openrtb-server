package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Impression
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object ImpressionValidators {

  object BannerOrVideoOrNative extends Validator[Impression] {

    def apply(impression: Impression): Result = {
      val isBanner: Boolean = impression.banner.isDefined
      val isVideo: Boolean = impression.video.isDefined
      val isNative: Boolean = impression.native.isDefined
      val isBannerOrVideoOrNative: Boolean = isBanner || isVideo || isNative
      val constraint: String = "Impression should contain Banner or Video or App."

      validate(impression, isBannerOrVideoOrNative, constraint)
    }

  }

  object `bidfloor` extends Validator[Impression] {

    def apply(impression: Impression): Result =
      validateEmptyOrPositive(impression, impression.bidfloor, "bidfloor")

  }

}