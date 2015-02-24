package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Video
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object VideoValidators {

  object Duration extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositiveInt(video, video.minduration, "minduration")
        .and(validateEmptyOrPositiveInt(video, video.maxduration, "maxduration"))

  }

  object Size extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositiveInt(video, video.w, "w")
        .and(validateEmptyOrPositiveInt(video, video.h, "h"))

  }

  object BitRate extends Validator[Video] {

    def apply(banner: Video): Result =
      validateEmptyOrPositiveInt(banner, banner.minbitrate, "minbitrate")
        .and(validateEmptyOrPositiveInt(banner, banner.maxbitrate, "maxbitrate"))

  }

}