package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Video
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object VideoValidators {

  object Duration extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositiveInt(video.minduration, "Video.minduration")
        .and(validateEmptyOrPositiveInt(video.maxduration, "Video.maxduration"))

  }

  object Size extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositiveInt(video.w, "Video.w")
        .and(validateEmptyOrPositiveInt(video.h, "Video.h"))

  }

  object BitRate extends Validator[Video] {

    def apply(video: Video): Result =
      validateEmptyOrPositiveInt(video.minbitrate, "Video.minbitrate")
        .and(validateEmptyOrPositiveInt(video.maxbitrate, "Video.maxbitrate"))

  }

}