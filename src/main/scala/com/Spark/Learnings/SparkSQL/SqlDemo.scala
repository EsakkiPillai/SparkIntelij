package com.Spark.Learnings.SparkSQL


import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by etpil on 8/23/2017.
  * E:\DataLakes\Spark_Play\SparkSql\sample.json
  */

object SqlDemo {

def simpleJson()={
  val sc = new SparkContext( new SparkConf().setAppName("SQLDEMO").setMaster("local") )
  val sqlcontext = new SQLContext(sc)
  import sqlcontext.implicits._
  val cust_name_stg =sqlcontext.read.json("E:\\DataLakes\\Spark_Play\\SparkSql\\sample.json")
  println("Schema for the cust_name_stg"+cust_name_stg.printSchema())
  println("name column"+cust_name_stg.select("name").show())
  cust_name_stg.select($"name", $"speed"+1).show()
  println("Where Clause")
  cust_name_stg.filter($"speed" > 300).show()
  // Count the niumber of cars whose speed is greater than 300
  cust_name_stg.groupBy($"speed").count().show()
  //create temp table
  cust_name_stg.registerTempTable("customer_stg")
  //querying the temptable
  sqlcontext.sql("select * from customer_stg")


}
def jsoncase={
  val sc = new SparkContext( new SparkConf().setAppName("SQLDEMO").setMaster("local") )
  val sqlcontext = new SQLContext(sc)
  val jsonSrcFile="E:\\DataLakes\\Spark_Play\\SparkSql\\sample.json"
  sqlcontext.read.schema(buildSchema()).json(jsonSrcFile).show()

}
  def buildSchema() : StructType = {
    val schema = StructType(
      Array(
        StructField("itemNo", IntegerType, true),
        StructField("name", StringType, true),
        StructField("speed", IntegerType, true),
        StructField("weight", IntegerType, true)
      )
    )
      schema
  }

  def main(args: Array[String]): Unit = {
  println("======================================================")
    jsoncase
    println("======================================================")
  }
}

case class customer( itemNo:Int , name:String,  speed:Int ,  weight:Int)

