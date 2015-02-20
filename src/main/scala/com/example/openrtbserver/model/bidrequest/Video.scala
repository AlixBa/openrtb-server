package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant._

case class Video(mimes: Seq[String], minduration: Option[Int], maxduration: Option[Int],
                 protocols: Option[Seq[VideoProtocol]], w: Option[Int], h: Option[Int],
                 startdelay: Option[VideoStartDelay], linearity: Option[VideoLinearity], sequence: Option[Int],
                 battr: Option[Seq[CreativeAttribute]], maxextended: Option[Int], minbitrate: Option[Int],
                 maxbitrate: Option[Int], boxingallowed: Option[BooleanAsInt],
                 playbackmethod: Option[Seq[VideoPlaybackMethod]], delivery: Option[Seq[ContentDeliveryMethod]],
                 pos: Option[AdPosition], companionad: Option[Seq[Banner]], api: Option[Seq[API]],
                 companiontype: Option[Seq[VASTCompanionType]], ext: Option[Any])
