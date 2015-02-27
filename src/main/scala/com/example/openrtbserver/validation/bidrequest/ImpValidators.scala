package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Imp
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object ImpValidators {

  object BannerOrVideoOrNative extends Validator[Imp] {

    type ObjectName = String
    type ObjectValue = Any

    def apply(impression: Imp): Result = {
      val isBanner: Boolean = impression.banner.isDefined
      val isVideo: Boolean = impression.video.isDefined
      val isNative: Boolean = impression.native.isDefined
      val isBannerOrVideoOrNative: Boolean = isBanner || isVideo || isNative

      val constraint: String = "should contain at least one Banner or Video or App."
      val value: Map[ObjectName, ObjectValue] =
        Map("Banner" -> impression.banner, "Video" -> impression.video, "Native" -> impression.native)

      validate(isBannerOrVideoOrNative, value, constraint, Option("Impression"))
    }

  }

  object `bidfloor` extends Validator[Imp] {

    def apply(impression: Imp): Result =
      validateEmptyOrPositiveFloat(impression.bidfloor, "Impression.bidfloor")

  }

}