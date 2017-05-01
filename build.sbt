name := "poe-parser"

version := "1.0"

scalaVersion := "2.11.8"
// Used to be 2.12.1, but reverting to 2.11.8 for compatability with play

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver_2.11
libraryDependencies += "org.mongodb.scala" % "mongo-scala-driver_2.11" % "2.0.0"

unmanagedBase := baseDirectory.value / "lib"