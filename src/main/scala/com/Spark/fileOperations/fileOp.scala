package com.Spark.fileOperations

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.PrintWriter

import org.apache.spark.{SparkConf, SparkContext}





object fileop{

  val sc = new SparkContext( new SparkConf().setAppName("File Operation").setMaster("local[*]"))
  val fs = FileSystem.get(sc.hadoopConfiguration)

    def fileCreation(filepath:String)={
      fs.create(new Path(filepath))
      println("New File\t"+ filepath +"\twas created Successfully")
    }

  def filedelete(filepath:String)={
    val srcFile = new Path(filepath)
    fs.delete(srcFile,true)
    println("Files Deleted Successfully")
  }
   def fileexists(filepath:String , createNewFile:Boolean)={
     val srcfile = new Path(filepath)
     if(!fs.exists(srcfile)){
       println("Files is not available in the path")
       if(createNewFile) fileCreation(filepath)
       else println(" As per Users suggestion we are not creating new files even though files are not There")
     }else{
       println("Files are available in the Path")
     }
  }
  def main(args: Array[String]): Unit = {

    filedelete("E:\\DataLakes\\Spark_Play\\sample.txt")
    fileexists("E:\\DataLakes\\Spark_Play\\sample.txt",true)
  }

}
