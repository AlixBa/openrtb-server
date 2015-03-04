package com.example.openrtbserver.model.bidresponse

import com.example.openrtbserver.model.constant.BooleanAsInt

import scalaz.NonEmptyList

case class SeatBid(bid: NonEmptyList[Bid], seat: Option[String], group: Option[BooleanAsInt], ext: Option[Any])

object SeatBid {

  def minimal(bid: NonEmptyList[Bid]): SeatBid = SeatBid(bid, None, None, None)

}