import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "trainon"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "com.google.oauth-client" % "google-oauth-client" % "1.16.0-rc",
    "org.mockito" % "mockito-all" % "1.9.5" % "test")

  val main = play.Project(appName, appVersion, appDependencies).settings( // Add your own project settings here      
  )
}
