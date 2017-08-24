package com.Spark.Learnings.SparkSQL

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by etpil on 8/23/2017.
  * we are going to read the json file and create the schema directly and programmatically
  */
object SparkSql {


  def simplejson()={

    val sqlcontext = new SQLContext( new SparkContext(new SparkConf().setAppName("ComplexJasonReader").setMaster("local")) )
    sqlcontext.setConf("spark.sql.shuffle.partitions","2")
    val fileName = "E:\\DataLakes\\Spark_Play\\SparkSql\\data.json"
    val srctable = sqlcontext.read.json(fileName)
    println(srctable.printSchema())
  }

  def complexJson={
    val objjsonBuilder = new jsonBuilder()
    val sqlcontext = new SQLContext( new SparkContext(new SparkConf().setAppName("ComplexJasonReader").setMaster("local")) )
    sqlcontext.setConf("spark.sql.shuffle.partitions","2")
    val fileName = "E:\\DataLakes\\Spark_Play\\SparkSql\\data.json"
    val srctable_cx = sqlcontext.read.format("json").schema(objjsonBuilder.schemabuilder()).json(fileName)
    println(srctable_cx.printSchema())
    srctable_cx.show()

    srctable_cx.registerTempTable("srctable")
    sqlcontext.sql("select  name, preferences.preferred_vet from srctable ").show
  }

  def main(args: Array[String]): Unit = {
    println("======================================================================================")
    //simplejson()
    complexJson
    println("======================================================================================")
  }

}

 class jsonBuilder(){

  def schemabuilder()={

      val  schema = StructType(
        Array(
          StructField("name",StringType,true) ,
          StructField("num_pets",LongType,true) ,
          StructField("paid_in_full",BooleanType,true) ,
          StructField("preferences",MapType(StringType,StringType,true),true) ,
          StructField("registered_on",DateType,true),
          StructField("visits",ArrayType(TimestampType,true),true)
      )

      )
    schema
  }
}
