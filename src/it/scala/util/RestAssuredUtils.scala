package util

import config.AppConfig
import io.restassured.RestAssured
import io.restassured.response.Response
import AppConfig.appConfig.http._

trait RestAssuredUtils {
  def apiGetRequest(route: String = "hello"): Response =
    RestAssured.when().get(s"http://$hostname:$port/$route")
}
