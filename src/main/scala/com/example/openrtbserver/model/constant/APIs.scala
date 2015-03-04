package com.example.openrtbserver.model.constant

trait API extends Constant {
  final type Value = Int
}

object APIs extends Constants[API] {

  val values: Seq[API] =
    List(VPAID1, VPAID2, MRAID1, ORMMA, MRAID2)

  case object VPAID1 extends API {
    def value: Int = 1
  }

  case object VPAID2 extends API {
    def value: Int = 2
  }

  case object MRAID1 extends API {
    def value: Int = 3
  }

  case object ORMMA extends API {
    def value: Int = 4
  }

  case object MRAID2 extends API {
    def value: Int = 5
  }

}
