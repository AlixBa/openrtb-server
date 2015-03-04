package com.example.openrtbserver.model.constant

sealed trait BooleanAsInt extends Constant {
  final type Value = Int
}

object BooleansAsInt extends Constants[BooleanAsInt] {

  val values: Seq[BooleanAsInt] = List(`false`, `true`)

  case object `false` extends BooleanAsInt {
    def value: Int = 0
  }

  case object `true` extends BooleanAsInt {
    def value: Int = 1
  }

}