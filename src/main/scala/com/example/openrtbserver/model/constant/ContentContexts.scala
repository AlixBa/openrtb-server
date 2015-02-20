package com.example.openrtbserver.model.constant

trait ContentContext extends Constant {
  final type Value = Int
}

object ContentContexts extends Constants[ContentContext] {

  val values: List[ContentContext] =
    List(Video, Game, Music, Application, Text, Other, Unknown)

  case object Video extends ContentContext {
    def value: Int = 1
  }

  case object Game extends ContentContext {
    def value: Int = 2
  }

  case object Music extends ContentContext {
    def value: Int = 3
  }

  case object Application extends ContentContext {
    def value: Int = 4
  }

  case object Text extends ContentContext {
    def value: Int = 5
  }

  case object Other extends ContentContext {
    def value: Int = 6
  }

  case object Unknown extends ContentContext {
    def value: Int = 7
  }

}
