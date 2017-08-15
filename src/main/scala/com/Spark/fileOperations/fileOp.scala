package com.Spark.fileOperations

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.PrintWriter

import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by etpillai on 8/14/2017.
  * will be working on the FileSystem
  */
/*object Fileop {

  val conf = new Configuration()
  val hdfsCoreSitePath = new Path("core-site.xml")
   val hdfsHDFSSitePath = new Path("hdfs-site.xml")
 // conf.set("fs.defaultFS","hdfs://192.168.30.147:8020")
  val fs= FileSystem.get(conf)

  def fileOperations(fPath:String) = {

    val fullFilePath = new Path("/esak/August/"+fPath)
    fs.create(fullFilePath)
    println("We have created the new File in the HDFS Location")

  }


  def main(args: Array[String]): Unit = {

    fileOperations("sample.txt")
  }

}*/


object fileop{

  val sc = new SparkContext( new SparkConf().setAppName("File Operation").setMaster("local[*]"))
  val fs = FileSystem.get(sc.hadoopConfiguration)

  def main(args: Array[String]): Unit = {
    fs.create(new Path("E:\\DataLakes\\Spark_Play\\sample.txt"))
  }

}
