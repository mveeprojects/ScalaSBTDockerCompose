package config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

object AppConfig extends ActorSystemConfig {

  case class HttpConfig(hostname: String, port: Int)

  case class Config(http: HttpConfig)

  val appConfig: Config = ConfigSource.default.loadOrThrow[Config]
}
