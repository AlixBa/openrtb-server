package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.ContentCategory

case class Publisher(id: Option[String], name: Option[String], cat: Option[ContentCategory], domain: Option[String],
                     ext: Option[Any])

object Publisher {

  def minimal: Publisher = Publisher(None, None, None, None, None)

}