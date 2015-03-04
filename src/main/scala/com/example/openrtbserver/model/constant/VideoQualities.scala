package com.example.openrtbserver.model.constant

trait VideoQuality extends Constant {
  final type Value = Int
}

object VideoQualities extends Constants[VideoQuality] {

  val values: Seq[VideoQuality] =
    List(Unknown, ProfessionallyProduced, Prosumer, UGC)

  case object Unknown extends VideoQuality {
    def value: Int = 0
  }

  case object ProfessionallyProduced extends VideoQuality {
    def value: Int = 1
  }

  case object Prosumer extends VideoQuality {
    def value: Int = 2
  }

  case object UGC extends VideoQuality {
    def value: Int = 3
  }

}