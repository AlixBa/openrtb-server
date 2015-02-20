package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant._

case class Content(id: Option[String], episode: Option[Int], title: Option[String], series: Option[String],
                   season: Option[String], producer: Option[Producer], url: Option[String],
                   cat: Option[Seq[ContentCategory]], videoquality: Option[VideoQuality],
                   context: Option[ContentContext], contentrating: Option[String], userrating: Option[String],
                   qagmediarating: Option[QAGMediaRating], keywords: Option[String], livestream: Option[BooleanAsInt],
                   sourcerelationship: Option[SourceRelationship], len: Option[Int], language: Option[String],
                   embeddable: Option[BooleanAsInt], ext: Option[Any])
