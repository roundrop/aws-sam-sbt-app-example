lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.13.2",

  sources in (Compile, doc) := Seq.empty,
  scalacOptions in Compile ++= Seq(
    "-feature",
    "-deprecation",
    "-unchecked",
    "-Xfatal-warnings",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-language:implicitConversions"
  ),
  scalacOptions in (Compile, console) ++= Seq("-Ywarn-unused:-imports"),
  javaOptions in Test ++= Seq(
    "-Ddeploy.env=test",
    "-XX:+CMSClassUnloadingEnabled",
    "-XX:+UseConcMarkSweepGC",
  )
)

lazy val appSettings = Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.2.1",
  "com.amazonaws" % "aws-lambda-java-events" % "3.1.0"
)

lazy val root = (project in file("."))
  .aggregate(common, lambda1, lambda2)
  .settings(
    commonSettings,
    name := "aws-sam-sbt-app-example",
    publishArtifact := false
  )

lazy val common = (project in file("common"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.0" % Test,
    ),
    name := "aws-sam-sbt-app-example-common"
  )

lazy val lambda1 = (project in file("lambda1"))
  .settings(
    commonSettings,
    name := "aws-sam-sbt-app-example-lambda1",
    libraryDependencies ++= appSettings
  )
  .dependsOn(common % "test->test;compile->compile")

lazy val lambda2 = (project in file("lambda2"))
  .settings(
    commonSettings,
    name := "aws-sam-sbt-app-example-lambda2",
    libraryDependencies ++= appSettings
  )
  .dependsOn(common % "test->test;compile->compile")
