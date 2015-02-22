package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Device
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object DeviceValidators {

  object `ipv4` extends Validator[Device] {

    val ipv4 = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$".r

    def apply(device: Device): Result = {
      val isIPV4: Boolean = device.ip.fold(true)(ipv4.findFirstIn(_).isDefined)
      val constraint: String = "ip is not in IPV4 format."

      validate(device, isIPV4, constraint)
    }

  }

  object `ipv6` extends Validator[Device] {

    val ipv6 = "(?i)^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$".r

    def apply(device: Device): Result = {
      val isIPV6: Boolean = device.ipv6.fold(true)(ipv6.findFirstIn(_).isDefined)
      val constraint: String = "ipv6 is not in IPV6 format."

      validate(device, isIPV6, constraint)
    }

  }

  object Size extends Validator[Device] {

    def apply(device: Device): Result =
      validateEmptyOrPositive(device, device.w, "w")
        .and(validateEmptyOrPositive(device, device.h, "h"))

  }

  object `ppi` extends Validator[Device] {

    def apply(device: Device): Result =
      validateEmptyOrPositive(device, device.ppi, "ppi")

  }

}