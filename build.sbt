name := "poe-parser"

version := "0.1.4"

scalaVersion := "2.11.8"

resolvers += "Lcl" at  "file:///C:/Users/j/.ivy2/local/default"

// https://github.com/typesafehub/scala-logging
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver_2.11
libraryDependencies += "org.mongodb.scala" % "mongo-scala-driver_2.11" % "2.0.0"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json_2.11
libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.6.3"

libraryDependencies += "default" % "poe-constants_2.11" % "0.0.6"