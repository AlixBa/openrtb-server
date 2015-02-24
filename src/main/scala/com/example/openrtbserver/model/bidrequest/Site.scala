package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.{ BooleanAsInt, ContentCategory }

case class Site(id: Option[String], name: Option[String], domain: Option[String], cat: Option[Seq[ContentCategory]],
                sectioncat: Option[Seq[ContentCategory]], pagecat: Option[Seq[ContentCategory]], page: Option[String],
                ref: Option[String], search: Option[String], mobile: Option[BooleanAsInt],
                privacypolicy: Option[BooleanAsInt], publisher: Option[Publisher], content: Option[Content],
                keywords: Option[String], ext: Option[Any])

object Site {

  def minimal: Site =
    Site(None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  def recommended(id: String): Site = minimal.copy(id = Option(id))

}