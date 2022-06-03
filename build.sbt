ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "sandbox"
  )

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.3.11"
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
addCompilerPlugin(
  "org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full
)

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.3.11"
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
libraryDependencies += "co.fs2" %% "fs2-core" % "3.2.7"

addCompilerPlugin(
  "org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full
)
