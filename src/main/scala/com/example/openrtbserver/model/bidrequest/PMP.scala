package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.BooleanAsInt

case class PMP(private_auction: Option[BooleanAsInt], deals: Option[Seq[Deal]], ext: Option[Any])
