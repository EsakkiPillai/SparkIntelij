package com.Spark.fileOperations

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.{SparkConf, SparkContext}

import scala.tools.ant.Pack200Task

/**
  * Created by etpil on 8/15/2017.
  * Simple WordCount Application
  */
object wordCountApplication{

  def main(args: Array[String]): Unit = {

  val props:Config = ConfigFactory.load()
   val conf = new SparkConf().setAppName("Simple-WordCount-Application").setMaster(props.getConfig(args(0)).getString("executionMode")).set("spark.ui.port","45621")        /*setMaster(local[*]) ) */
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
  val fs = FileSystem.get(sc.hadoopConfiguration)
  val inputFile =  props.getConfig(args(1)).getString("inputPath")              // "E:\\DataLakes\\WordCount\\rr.txt"
  val outputFile = props.getConfig(args(1)).getString("outputPath")             //args(1)  //"E:\\DataLakes\\WordCount\\WordCount_Output"

  if(!fs.exists(new Path(inputFile))) {
    println("Input File is Not Available. Please  Check the Input Path")
  }

  if(fs.exists(new Path(outputFile))){
    println("OutPut Directory Already Exists... We are Deleting the Directory")
    fs.delete(new Path(outputFile),true)
    println("Output Directory was deleted Sucessfully")

  }

  val srcFile = sc.textFile(inputFile)
  val words = srcFile.flatMap(rec => rec.split(" ").map(rec => (rec,1)))
  val results = words.reduceByKey((tot, ele) => tot+ele)
  results.collect().foreach(println)

  println("Saving the results to the Hdfs/local File....")
  results.saveAsTextFile(outputFile)
  println("File saved to the Local....")


  sc.stop()
  println("we stooped the sc"+ sc.isStopped)


  }
}
