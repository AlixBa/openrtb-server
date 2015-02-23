package com.example.openrtbserver.model.bidresponse

import com.example.openrtbserver.model.constant.NoBidCode

case class BidResponse(id: String, seatbid: Seq[SeatBid], bidid: Option[String], cur: Option[String],
                       customdata: Option[String], nbr: Option[NoBidCode], ext: Option[Any])

object BidResponse {

  def minimal(id: String): BidResponse = BidResponse(id, Seq(), None, None, None, None, None)

}