import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import util.RestAssuredUtils

class RouteSpec extends AnyFeatureSpec with GivenWhenThen with Matchers with RestAssuredUtils {
  Feature("hello endpoint") {
    Scenario("/hello endpoint should return 200") {
      When("I send a request to the /hello endpoint")
      val response = apiGetRequest()
      Then("I should receive a 200 response with message body \"Hello, World!\"")
      response.statusCode() shouldBe 200
      response.body().print() shouldBe "Hello, World!"
    }
  }
}
