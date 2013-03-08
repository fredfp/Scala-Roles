import sbt._
import Keys._

object ApplicationBuild extends Build {

  val main = Project(id = "crash", base = file(".")).settings(// Add your own project settings here
    scalaVersion := "2.10.1-RC3",
    scalaSource in Compile <<= baseDirectory(_ / "src")
  )
}
