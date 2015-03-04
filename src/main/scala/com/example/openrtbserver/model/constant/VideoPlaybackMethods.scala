package com.example.openrtbserver.model.constant

trait VideoPlaybackMethod extends Constant {
  final type Value = Int
}

object VideoPlaybackMethods extends Constants[VideoPlaybackMethod] {

  val values: Seq[VideoPlaybackMethod] =
    List(AutoPlaySoundOn, AutoPlaySoundOff, ClickToPlay, MouseOver)

  case object AutoPlaySoundOn extends VideoPlaybackMethod {
    def value: Int = 1
  }

  case object AutoPlaySoundOff extends VideoPlaybackMethod {
    def value: Int = 2
  }

  case object ClickToPlay extends VideoPlaybackMethod {
    def value: Int = 3
  }

  case object MouseOver extends VideoPlaybackMethod {
    def value: Int = 4
  }

}