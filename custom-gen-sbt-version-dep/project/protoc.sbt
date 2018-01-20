addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.13")

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "compilerplugin" % "0.7.0-rc7",
  "com.typesafe.play" %% "play-json" % "2.6.8"
)
