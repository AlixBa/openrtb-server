package com.example.openrtbserver.model.constant

trait CreativeAttribute extends Constant {
  final type Value = Int
}

object CreativeAttributes extends Constants[CreativeAttribute] {

  val values: Seq[CreativeAttribute] =
    List(AutoPlayAudioAd, UserInitiatedAudioAd)

  case object AutoPlayAudioAd extends CreativeAttribute {
    def value: Int = 1
  }

  case object UserInitiatedAudioAd extends CreativeAttribute {
    def value: Int = 2
  }

  // TODO: Others

}
