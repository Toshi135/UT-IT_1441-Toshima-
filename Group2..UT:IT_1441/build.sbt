name := "Group2_UT_IT_assignment"

version := "0.1"

scalaVersion := "2.12.12"

lazy val question_1_2 = project.in(file("question_1_2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.13" % Test
    )

  )


libraryDependencies ++= Seq("org.mockito" %% "mockito-scala-scalatest" % "1.15.0" % Test,
                            "org.mockito" %% "mockito-scala" % "1.14.8",
                            "org.scalatest" %% "scalatest" % "3.2.2" % Test  ,
                            "org.mockito" % "mockito-core" % "1.9.5" % "test",
                            "org.scalatest" %% "scalatest" % "3.1.1" % "test",
                            "org.mockito" %% "mockito-scala" % "1.5.12" % "test")
lazy val question_3 = project.in(file("question 3"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.13" % Test
    )

  )