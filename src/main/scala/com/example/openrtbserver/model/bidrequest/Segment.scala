package com.example.openrtbserver.model.bidrequest

case class Segment(id: Option[String], name: Option[String], value: Option[String], ext: Option[Any])

object Segment {

  def minimal: Segment = Segment(None, None, None, None)

}
