package com.example.openrtbserver.validation.bidrequest

import com.example.openrtbserver.model.bidrequest.Geo
import com.wix.accord.dsl._

object GeoValidators {

  val latitude = validator[Geo] { geo ⇒
    geo.lat.as("Geo.lat").each.should(be.between(-90F, 90F))
  }

  val longitude = validator[Geo] { geo ⇒
    geo.lon.as("Geo.lon").each.should(be.between(-180F, 180F))
  }

}