package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant._

case class Banner(w: Option[Int], h: Option[Int], wmax: Option[Int], hmax: Option[Int], wmin: Option[Int],
                  hmin: Option[Int], id: Option[String], btype: Option[Seq[BannerAdType]],
                  battr: Option[Seq[CreativeAttribute]], pos: Option[AdPosition], mimes: Option[Seq[String]],
                  topframe: Option[BooleanAsInt], expdir: Option[Seq[ExpandableDirection]], api: Option[Seq[API]],
                  ext: Option[Any])
