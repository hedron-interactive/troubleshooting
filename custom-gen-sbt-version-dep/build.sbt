import scalapb.compiler.Version.scalapbVersion

lazy val lib = (project in file("lib"))
  .settings(
    name := "lib"//,
    // libraryDependencies ++= Seq(
    //  "com.trueaccord.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf"
    //),

    // Dependencies marked with "protobuf" get extracted to target / protobuf_external
    // In addition to the JAR we care about, the protobuf_external directory
    // is going to contain protos from ScalaPB runtime and Google's standard
    // protos.  In order to avoid compiling them, we restrict what's compiled
    // to a subdirectory of protobuf_external
    // PB.protoSources in Compile += target.value / "protobuf_external" / "com" / "thesamet",

    //PB.targets in Compile := Seq(
    //  scalapb.gen() -> (sourceManaged in Compile).value,
    //  MyCodeGenerator -> (sourceManaged in Compile).value
    //)
  )

// Sub1 contains a proto file that imports a proto from test-protos.
// And another proto file from the protos project.
lazy val app = (project in file("app"))
  .settings(
    name := "app",

    // We add again the protos we need here so we can compile the protos
    // under `sub1/src/main/protobuf`. However, we do not generate code
    // for the dependencies this time since this is provided through the
    // dependency on protos project.
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf"
    )
  )
  .dependsOn(lib)
