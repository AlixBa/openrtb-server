package com.example.openrtbserver.model.constant

trait ExpandableDirection extends Constant {
  final type Value = Int
}

object ExpandableDirections extends Constants[ExpandableDirection] {

  val values: Seq[ExpandableDirection] =
    List(Left, Right, Up, Down, Fullscreen)

  case object Left extends ExpandableDirection {
    def value: Int = 1
  }

  case object Right extends ExpandableDirection {
    def value: Int = 2
  }

  case object Up extends ExpandableDirection {
    def value: Int = 3
  }

  case object Down extends ExpandableDirection {
    def value: Int = 4
  }

  case object Fullscreen extends ExpandableDirection {
    def value: Int = 5
  }

}