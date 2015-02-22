package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Content
import com.example.openrtbserver.validation._
import com.wix.accord.{Result, Validator}

object `len` extends Validator[Content] {

  def apply(content: Content): Result =
    validateEmptyOrPositive(content, content.len, "len")

}