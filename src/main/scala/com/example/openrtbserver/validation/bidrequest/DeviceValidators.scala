package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Device
import com.wix.accord.ViolationBuilder.result
import com.wix.accord.dsl._
import com.wix.accord.{ Result, RuleViolation, Validator }

object DeviceValidators {

  val `ipv4` = new Validator[Device] {

    def apply(device: Device): Result = {
      val ipv4 = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$".r
      val isIPV4 = device.ip.fold(true)(ipv4.findFirstIn(_).isDefined)

      val constraint = "not in IPV4 format"
      val description = Option("Device.ip")

      result(isIPV4, RuleViolation(device.ip, constraint, description))
    }

  }

  val `ipv6` = new Validator[Device] {

    def apply(device: Device): Result = {
      val ipv6 = "(?i)^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$".r
      val isIPV6 = device.ipv6.fold(true)(ipv6.findFirstIn(_).isDefined)

      val constraint = "not in IPV6 format"
      val description = Option("Device.ipv6")

      result(isIPV6, RuleViolation(device.ip, constraint, description))
    }

  }

  val size: Validator[Device] = validator[Device] { device ⇒
    device.w.as("Device.w").each.should(be >= 0)
    device.h.as("Device.h").each.should(be >= 0)
  }

  val `ppi`: Validator[Device] = validator[Device] { device ⇒
    device.ppi.as("Device.ppi").each.should(be >= 0)
  }

}