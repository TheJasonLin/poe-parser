name := "poe-parser"

version := "0.0.5"

scalaVersion := "2.11.8"

resolvers += "Lcl" at  "file:///C:/Users/j/.ivy2/local/default"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver_2.11
libraryDependencies += "org.mongodb.scala" % "mongo-scala-driver_2.11" % "2.0.0"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json_2.11
libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.6.3"

libraryDependencies += "default" % "poe-constants_2.11" % "0.0.6"