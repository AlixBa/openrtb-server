package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Video
import com.wix.accord.dsl._

object VideoValidators {

  val duration = validator[Video] { video ⇒
    video.minduration.as("Video.minduration").each.should(be >= 0)
    video.maxduration.as("Video.maxduration").each.should(be >= 0)
  }

  val size = validator[Video] { video ⇒
    video.w.as("Video.w").each.should(be >= 0)
    video.h.as("Video.h").each.should(be >= 0)
  }

  val bitRate = validator[Video] { video ⇒
    video.minbitrate.as("Video.minbitrate").each.should(be >= 0)
    video.maxbitrate.as("Video.maxbitrate").each.should(be >= 0)
  }

}