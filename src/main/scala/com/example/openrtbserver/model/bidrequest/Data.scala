package com.example.openrtbserver.model.bidrequest

case class Data(id: Option[String], name: Option[String], segment: Option[Seq[Segment]], ext: Option[Any])

object Data {
  
  def minimal: Data = Data(None, None, None, None)

}