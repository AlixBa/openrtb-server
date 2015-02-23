package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.ContentCategory

case class Producer(id: Option[String], name: Option[String], cat: Option[ContentCategory], domain: Option[String],
                    ext: Option[Any])

object Producer {

  def minimal: Producer = Producer(None, None, None, None, None)

}