package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.{BooleanAsInt, ConnectionType, DeviceType}

case class Device(ua: Option[String], geo: Option[Geo], dnt: Option[BooleanAsInt], lmt: Option[BooleanAsInt],
                  ip: Option[String], ipv6: Option[String], devicetype: Option[DeviceType], make: Option[String],
                  model: Option[String], os: Option[String], osv: Option[String], hvm: Option[String], h: Option[Int],
                  w: Option[Int], ppi: Option[Int], pxratio: Option[Float], js: Option[BooleanAsInt],
                  flashver: Option[String], language: Option[String], carrier: Option[String],
                  connectiontype: Option[ConnectionType], ifa: Option[String], didsha1: Option[String],
                  didmd5: Option[String], dpidsha1: Option[String], dpidmd5: Option[String], macsha1: Option[String],
                  macmd5: Option[String], ext: Option[Any])