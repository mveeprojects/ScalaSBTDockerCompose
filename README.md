# ScalaSBTDockerCompose

Example of implementing the SBT docker compose plugin on a Scala project.

This project utilises the [SBT Native Packager](https://github.com/sbt/sbt-native-packager) plugin to generate the app image and the [SBT Docker Compose](https://github.com/Tapad/sbt-docker-compose) plugin for orchestrating containers.

The example here is of a simple [Akka HTTP](https://doc.akka.io/docs/akka-http/current/introduction.html) server.

The endpoint that is implemented can be called by curling (GET) `http://localhost:8080/hello`, or by copying this into your browser.

An SBT Alias has been added to demonstrate combining the SBT commands from the docker compose plugin with commands from [SBT integrationTest](https://www.scala-sbt.org/1.x/docs/Testing.html#Integration+Tests) (for example) to form a simple command to build and run the app under test, followed by running tests, and then finally shutting all containers down. All of this can be achieved by just running `sbt "runItTests"` in this example.

### Steps to implement SBT Docker Compose

1. Add both the SBT Docker Compose and SBT Native Packager to your [project/plugins.sbt](project/plugins.sbt) file.
2. Enable both of the above plugins in your [build.sbt](build.sbt) file, see `enablePlugins(JavaAppPackaging, DockerComposePlugin)`.
3. Add the `dockerImageCreationTask` to your [build.sbt](build.sbt) file.
4. Add a docker-compose.yml file either in the root of your project or under a [docker directory at the root of your project](docker/docker-compose.yml). 
   - Ensure the service name matches the name of your module according to your build.sbt file (in lowercase).
   - Ensure the image name is the name of your app followed by `<localBuild>` as the version, e.g. `scalasbtdockercompose:<localBuild>`.

You should now be able to run `sbt "dockerComposeUp"` to generate your app image and run your containers in docker compose, as well as `sbt "dockerComposeStop"` to bring them all down. 
