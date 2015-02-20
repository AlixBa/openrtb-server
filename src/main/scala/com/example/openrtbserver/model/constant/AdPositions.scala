package com.example.openrtbserver.model.constant

trait AdPosition extends Constant {
  final type Value = Int
}

object AdPositions extends Constants[AdPosition] {

  val values: List[AdPosition] =
    List(Unknown, AboveTheFold, BelowTheFold, Header, Footer, Sidebar, Fullscreen)

  case object Unknown extends AdPosition {
    def value: Int = 0
  }

  case object AboveTheFold extends AdPosition {
    def value: Int = 1
  }

  case object BelowTheFold extends AdPosition {
    def value: Int = 3
  }

  case object Header extends AdPosition {
    def value: Int = 4
  }

  case object Footer extends AdPosition {
    def value: Int = 5
  }

  case object Sidebar extends AdPosition {
    def value: Int = 6
  }

  case object Fullscreen extends AdPosition {
    def value: Int = 7
  }

}