name := "LearnScala"

version := "1.0"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/org.scala-lang/scala-library
libraryDependencies += "org.scala-lang" % "scala-library" % "2.10.6"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.10
libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.3"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.10
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.3"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.6.3"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming_2.10
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.3"

libraryDependencies += "org.apache.spark" % "spark-streaming-flume_2.10" % "1.6.3"

libraryDependencies += "org.apache.spark" % "spark-streaming-flume-sink_2.10" % "1.6.3"

libraryDependencies += "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.3"

//mysql Connector Dependency
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"

// kafka Client for custom Prodcer and Consumer
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
//libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.9.0.2.4.2.12-1"

