package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.{AuctionType, BooleanAsInt}

import scalaz.NonEmptyList

case class BidRequest(id: String, imp: NonEmptyList[Impression], site: Option[Site], app: Option[App],
                      device: Option[Device], user: Option[User], test: Option[BooleanAsInt], at: Option[AuctionType],
                      tmax: Option[Int], wseat: Option[Seq[String]], allimps: Option[BooleanAsInt],
                      cur: Option[Seq[String]], bcat: Option[Seq[String]], badv: Option[Seq[String]],
                      regs: Option[Regs], ext: Option[Any])