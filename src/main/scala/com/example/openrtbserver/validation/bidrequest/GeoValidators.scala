package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Geo
import com.example.openrtbserver.validation._
import com.wix.accord.{ Result, Validator }

object GeoValidators {

  object `lat` extends Validator[Geo] {

    def apply(geo: Geo): Result = {
      val isValid: Boolean = geo.lat.isEmptyOrGreaterThan(-90) && geo.lat.isEmptyOrLowerThan(90)
      val constraint: String = "lat should be between -90 and 90."

      validate(isValid, geo.lat, constraint, Option("Geo.lat"))
    }

  }

  object `lon` extends Validator[Geo] {

    def apply(geo: Geo): Result = {
      val isValid: Boolean = geo.lon.isEmptyOrGreaterThan(-180) && geo.lon.isEmptyOrLowerThan(180)
      val constraint: String = "lon should be between -180 and 180."

      validate(isValid, geo.lon, constraint, Option("Geo.lon"))
    }

  }

}