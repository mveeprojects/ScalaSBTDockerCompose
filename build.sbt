name := "ScalaSBTDockerCompose"

version := "0.1"

ThisBuild / scalaVersion := "2.13.7"

val AkkaVersion     = "2.6.8"
val AkkaHttpVersion = "10.2.7"
val pureConfig      = "0.14.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka"     %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka"     %% "akka-stream"      % AkkaVersion,
  "com.typesafe.akka"     %% "akka-http"        % AkkaHttpVersion,
  "com.github.pureconfig" %% "pureconfig"       % pureConfig
)

enablePlugins(JavaAppPackaging, DockerComposePlugin)
dockerImageCreationTask := (publishLocal in Docker).value
