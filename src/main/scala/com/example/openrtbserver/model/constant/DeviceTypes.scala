package com.example.openrtbserver.model.constant

trait DeviceType extends Constant {
  final type Value = Int
}

object DeviceTypes extends Constants[DeviceType] {

  val values: List[DeviceType] =
    List(MobileTablet, PC, ConnectedTV, Phone, Tablet, ConnectedDevice, SetTopBox)

  case object MobileTablet extends DeviceType {
    def value: Int = 1
  }

  case object PC extends DeviceType {
    def value: Int = 2
  }

  case object ConnectedTV extends DeviceType {
    def value: Int = 3
  }

  case object Phone extends DeviceType {
    def value: Int = 4
  }

  case object Tablet extends DeviceType {
    def value: Int = 5
  }

  case object ConnectedDevice extends DeviceType {
    def value: Int = 6
  }

  case object SetTopBox extends DeviceType {
    def value: Int = 7
  }

}