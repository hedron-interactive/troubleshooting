addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.12")

libraryDependencies ++= Seq(
  "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.6",
  "com.typesafe.play" %% "play-json" % "2.6.8"
)
