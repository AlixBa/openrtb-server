package com.example.openrtbserver.model.constant

trait ConnectionType extends Constant {
  final type Value = Int
}

object ConnectionTypes extends Constants[ConnectionType] {

  val values: Seq[ConnectionType] =
    List(Unknown, Ethernet, Wifi, CellularXG, Cellular2G, Cellular3G, Cellular4G)

  case object Unknown extends ConnectionType {
    def value: Int = 0
  }

  case object Ethernet extends ConnectionType {
    def value: Int = 1
  }

  case object Wifi extends ConnectionType {
    def value: Int = 2
  }

  case object CellularXG extends ConnectionType {
    def value: Int = 3
  }

  case object Cellular2G extends ConnectionType {
    def value: Int = 4
  }

  case object Cellular3G extends ConnectionType {
    def value: Int = 5
  }

  case object Cellular4G extends ConnectionType {
    def value: Int = 6
  }

}
