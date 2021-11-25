name := "ScalaSBTDockerCompose"

version := "0.1"

ThisBuild / scalaVersion := "2.13.7"

val akkaVersion       = "2.6.8"
val akkaHttpVersion   = "10.2.7"
val pureConfigVersion = "0.14.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka"     %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka"     %% "akka-stream"      % akkaVersion,
  "com.typesafe.akka"     %% "akka-http"        % akkaHttpVersion,
  "com.github.pureconfig" %% "pureconfig"       % pureConfigVersion
)

enablePlugins(JavaAppPackaging, DockerComposePlugin)
dockerImageCreationTask := (publishLocal in Docker).value
