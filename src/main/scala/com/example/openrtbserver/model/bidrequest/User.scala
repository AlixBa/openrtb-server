package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.Gender

case class User(id: Option[String], buyerid: Option[String], yop: Option[Int], gender: Option[Gender],
                keywords: Option[String], customdata: Option[String], geo: Option[Geo], data: Option[Seq[Data]],
                ext: Option[Any])

object User {

  def minimal: User =
    User(None, None, None, None, None, None, None, None, None)

  def recommended(id: String, buyerid: String) =
    minimal.copy(id = Option(id), buyerid = Option(buyerid))

}