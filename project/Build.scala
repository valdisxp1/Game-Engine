import sbt._
import Keys._

object GameEngineBuild extends Build {
	object Deps {
		object V {
			val Scala = "2.10.1"
		}
	}

	override lazy val settings = super.settings ++ Seq(
		scalaVersion := Deps.V.Scala
	)

	lazy val root = Project("game-engine", file("."), settings = Project.defaultSettings) aggregate (core, functional, demos)

	lazy val core = Project("game-engine-core", file("game-engine-core"), settings = Project.defaultSettings)
	lazy val functional = Project("game-engine-frp", file("game-engine-frp"), settings = Project.defaultSettings) dependsOn core
	lazy val demos = Project("game-engine-demos", file("game-engine-demos"), settings = Project.defaultSettings) dependsOn core
	lazy val net = Project("game-engine-net", file("game-engine-net"), settings = Project.defaultSettings) dependsOn core
}