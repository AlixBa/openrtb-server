package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Banner
import com.wix.accord.dsl._

object BannerValidators {

  val size = validator[Banner] { banner ⇒
    banner.w.as("Banner.w").each.should(be >= 0)
    banner.h.as("Banner.h").each.should(be >= 0)
  }

  val maxSize = validator[Banner] { banner ⇒
    banner.wmax.as("Banner.wmax").each.should(be >= 0)
    banner.hmax.as("Banner.hmax").each.should(be >= 0)
  }

  val minSize = validator[Banner] { banner ⇒
    banner.wmin.as("Banner.wmin").each.should(be >= 0)
    banner.hmin.as("Banner.hmin").each.should(be >= 0)
  }

}