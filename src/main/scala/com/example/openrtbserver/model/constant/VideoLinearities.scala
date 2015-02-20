package com.example.openrtbserver.model.constant

trait VideoLinearity extends Constant {
  final type Value = Int
}

object VideoLinearities extends Constants[VideoLinearity] {

  val values: List[VideoLinearity] =
    List(Linear, NonLinear)

  case object Linear extends VideoLinearity {
    def value: Int = 1
  }

  case object NonLinear extends VideoLinearity {
    def value: Int = 2
  }

}