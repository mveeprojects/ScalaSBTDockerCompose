import sbt._

object Dependencies {

  private object Versions {
    val akkaVersion        = "2.6.8"
    val akkaHttpVersion    = "10.2.7"
    val pureConfigVersion  = "0.14.0"
    val scalaTestVersion   = "3.2.10"
    val restAssuredVersion = "4.4.0"
  }

  val apiDependencies = Seq(
    "com.typesafe.akka"     %% "akka-actor-typed" % Versions.akkaVersion,
    "com.typesafe.akka"     %% "akka-stream"      % Versions.akkaVersion,
    "com.typesafe.akka"     %% "akka-http"        % Versions.akkaHttpVersion,
    "com.github.pureconfig" %% "pureconfig"       % Versions.pureConfigVersion
  )

  val testDependencies = Seq(
    "org.scalatest"         %% "scalatest"        % Versions.scalaTestVersion   % "it",
    "io.rest-assured"        % "rest-assured"     % Versions.restAssuredVersion % "it"
  )
}
