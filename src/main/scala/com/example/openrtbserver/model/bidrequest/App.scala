package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.{BooleanAsInt, ContentCategory}

case class App(id: Option[String], name: Option[String], bundle: Option[String], domain: Option[String],
               storeurl: Option[String], cat: Option[Seq[ContentCategory]], sectioncat: Option[Seq[ContentCategory]],
               pagecat: Option[Seq[ContentCategory]], ver: Option[String], privacypolicy: Option[BooleanAsInt],
               paid: Option[BooleanAsInt], publisher: Option[Publisher], content: Option[Content],
               keywords: Option[String], ext: Option[Any])
