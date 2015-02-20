package com.example.openrtbserver.model.bidresponse

import com.example.openrtbserver.model.constant.NoBidCode

case class BidResponse(id: String, seatbid: Seq[SeatBid], bidid: Option[String], cur: Option[String],
                       customdata: Option[String], nbr: Option[NoBidCode], ext: Option[Any])
