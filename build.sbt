name := "util"
version := "1.0"
scalaVersion := "2.11.6"

//libraryDependencies ++= Seq(
//  "org.apache.commons" % "commons-lang3" % "3.4"
//)

resolvers ++= Seq(
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "sonatype-snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "sonatype-releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-lang3" % "3.4",
  "org.specs2" % "specs2-core_2.11" % "3.3.1",
  "org.specs2" % "specs2_2.11" % "3.3.1"
)
