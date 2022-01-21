import sbt.{Def, _}

object Aliases {
  val customAliases: Seq[Def.Setting[State => State]] =
    addCommandAlias("runItTests", "dockerComposeUp; IntegrationTest/test; dockerComposeStop")
}
