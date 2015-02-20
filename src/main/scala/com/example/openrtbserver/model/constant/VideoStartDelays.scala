package com.example.openrtbserver.model.constant

trait VideoStartDelay extends Constant {
  final type Value = Int
}

object VideoStartDelays extends Constants[VideoStartDelay] {

  val values: List[VideoStartDelay] =
    List(PreRoll, GenericMidRoll, GenericPostRoll)

  case object PreRoll extends VideoStartDelay {
    def value: Int = 0
  }

  case object GenericMidRoll extends VideoStartDelay {
    def value: Int = -1
  }

  case object GenericPostRoll extends VideoStartDelay {
    def value: Int = -2
  }

}