package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Content
import com.wix.accord.Validator
import com.wix.accord.dsl._

object ContentValidators {

  val `len`: Validator[Content] = validator[Content] { content ⇒
    content.len.as("Content.len").each.should(be >= 0)
  }

}