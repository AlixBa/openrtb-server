package com.example.openrtbserver.model.bidresponse

import com.example.openrtbserver.model.constant.{ ContentCategory, CreativeAttribute }

case class Bid(id: String, impid: String, price: Float, adid: Option[String], nurl: Option[String], adm: Option[String],
               adomain: Option[Seq[String]], bundle: Option[String], iurl: Option[String], cid: Option[String],
               crid: Option[String], cat: Option[Seq[ContentCategory]], attr: Option[Seq[CreativeAttribute]],
               dealid: Option[String], h: Option[Int], w: Option[Int], ext: Option[Any])
