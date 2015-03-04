package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Imp
import com.wix.accord.ViolationBuilder.result
import com.wix.accord.dsl._
import com.wix.accord.{ Result, RuleViolation, Validator }

object ImpValidators {

  val bannerOrVideoOrNative = new Validator[Imp] {

    def apply(impression: Imp): Result = {
      val isBanner = impression.banner.isDefined
      val isVideo = impression.video.isDefined
      val isNative = impression.native.isDefined
      val isBannerOrVideoOrNative = isBanner || isVideo || isNative

      val description = Option("Imp")
      val constraint = "should contain at least one Banner or Video or App"
      val value = Map(
        "Banner" -> impression.banner,
        "Video" -> impression.video,
        "Native" -> impression.native
      )

      result(isBannerOrVideoOrNative, RuleViolation(value, constraint, description))
    }

  }

  val `bidfloor`: Validator[Imp] = validator[Imp] { imp ⇒
    imp.bidfloor.as("Imp.bidfloor").each.should(be >= 0F)
  }

}