package com.example.openrtbserver.configuration

import com.typesafe.config.ConfigFactory

/**
 * Trait exposing application.conf loaded by default as a Config object.
 */
trait ConfigurationAware {

  def config = LoadedConfig.config

}

private[configuration] object LoadedConfig {

  lazy val config = ConfigFactory.load

}
