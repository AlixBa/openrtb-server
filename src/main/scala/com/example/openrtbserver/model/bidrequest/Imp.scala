package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.BooleanAsInt
import com.example.openrtbserver.model.types._

case class Imp(id: String, banner: Option[Banner], video: Option[Video], native: Option[Native],
               displaymanager: Option[String], displaymanagerver: Option[String], instl: Option[BooleanAsInt],
               tagid: Option[String], bidfloor: Option[BidPrice], bidfloorcur: Option[Currency],
               secure: Option[BooleanAsInt], iframebuster: Option[Seq[String]], pmp: Option[Pmp],
               ext: Option[Any])

object Imp {

  def minimal(id: String): Imp =
    Imp(id, None, None, None, None, None, None, None, None, None, None, None, None, None)

}