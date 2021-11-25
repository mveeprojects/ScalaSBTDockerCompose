import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import config.AppConfig._

import scala.util.{Failure, Success}

object Main extends App {

  val route =
    path("hello") {
      get {
        complete(StatusCodes.OK, "Hello, World!")
      }
    }

  Http()
    .newServerAt(appConfig.http.hostname, appConfig.http.port)
    .bindFlow(route)
    .onComplete {
      case Success(_) =>
        println(s"Server now online. Please navigate to http://${appConfig.http.hostname}:${appConfig.http.port}/hello")
      case Failure(ex) =>
        println(s"App failed to start:\n${ex.getMessage}")
    }
}
