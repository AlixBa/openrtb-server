package com.example.openrtbserver.model.constant

sealed trait BooleanAsInt extends Constant {
  final type Value = Int
}

object BooleansAsInt extends Constants[BooleanAsInt] {

  val values: List[BooleanAsInt] = List(False, True)

  case object False extends BooleanAsInt {
    def value: Int = 0
  }

  case object True extends BooleanAsInt {
    def value: Int = 1
  }

}