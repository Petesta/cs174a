import net.litola.SassPlugin

name := "cs174a-databases"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick-extensions" % "1.0.0"
)     

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"

play.Project.playScalaSettings ++ SassPlugin.sassSettings
