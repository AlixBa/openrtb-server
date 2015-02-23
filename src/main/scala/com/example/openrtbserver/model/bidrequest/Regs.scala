package com.example.openrtbserver.model.bidrequest

import com.example.openrtbserver.model.constant.BooleanAsInt

case class Regs(coppa: Option[BooleanAsInt], ext: Option[Any])

object Regs {

 def minimal: Regs=Regs(None, None)

}