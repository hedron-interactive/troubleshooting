import scalapb.compiler.Version.scalapbVersion

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf",
  "com.typesafe.play" %% "play-json" % "2.6.7"
)

PB.protoSources in Compile += target.value / "protobuf_external" / "com" / "thesamet"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value,
  MyCodeGenerator -> (sourceManaged in Compile).value
)

