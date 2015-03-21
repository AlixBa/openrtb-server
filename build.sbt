name := "OpenRTB Server"

organization := "com.example"

version := "0.0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "org.scalaz" %% "scalaz-core" % "7.1.1",
  "com.wix" %% "accord-core" % "0.4.1",
  "com.typesafe" % "config" % "1.2.1"
)

