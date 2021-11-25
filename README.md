# ScalaSBTDockerCompose

Example of implementing the SBT docker compose plugin on a Scala project

This project utilises the [SBT Native Packager](https://github.com/sbt/sbt-native-packager) plugin to generate the app image amd the [SBT Docker Compose](https://github.com/Tapad/sbt-docker-compose) plugin for orchestrating containers.

The example here is of a simple [Akka HTTP](https://doc.akka.io/docs/akka-http/current/introduction.html) server.

The endpoint that is implemented can be called by curling `localhost:8080/hello`, or by copying this into your browser.


### Steps to implement SBT Docker Compose

1. Add both the SBT Docker Compose and SBT Native Packager to your [project/plugins.sbt](project/plugins.sbt) file.
2. Enable both of the above plugins in your [build.sbt](build.sbt) file, see `enablePlugins(JavaAppPackaging, DockerComposePlugin)`.
3. Add the `dockerImageCreationTask` to your [build.sbt](build.sbt) file.
4. Add a docker-compose.yml file either in the root of your project or under a [docker directory at the root of your project](docker/docker-compose.yml). 
   - Ensure the service name matches the name of your apps module according to your build.sbt file (in lowercase).
   - Ensure the image name is the name of your app followed by `<localBuild>` e.g. `scalasbtdockercompose:<localBuild>`

You should now be able to run `sbt "dockerComposeUp"` to generate your app image and run your containers in docker compose, as well as `sbt "dockerComposeDown"` to shut all containers down. 
