import Aliases.customAliases
import Dependencies._

name := "ScalaSBTDockerCompose"

version := "0.1"

ThisBuild / scalaVersion := "2.13.7"

configs(IntegrationTest)
Defaults.itSettings

customAliases

libraryDependencies ++= (
  apiDependencies ++ testDependencies
)

enablePlugins(JavaAppPackaging, DockerComposePlugin)
dockerImageCreationTask := (Docker / publishLocal).value
