package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Video
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object VideoValidators {

  object Duration extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositive(video, video.minduration, "minduration")
        .and(validateEmptyOrPositive(video, video.maxduration, "maxduration"))

  }

  object VSize extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositive(video, video.w, "w")
        .and(validateEmptyOrPositive(video, video.h, "h"))

  }

  object BitRate extends Validator[Video] {

    def apply(banner: Video): Result =
      validateEmptyOrPositive(banner, banner.minbitrate, "minbitrate")
        .and(validateEmptyOrPositive(banner, banner.maxbitrate, "maxbitrate"))

  }

}