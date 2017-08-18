package com.Spark.fileOperations

import java.io.PrintWriter

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.log4j.Logger
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source
/**
  * Created by etpil on 8/18/2017.
  */
class fileLevelOperation {

  val log = Logger.getLogger(this.getClass.getName)
  val sc = new SparkContext( new SparkConf().setAppName("File Operations").setMaster("local[*]"))
  val fs = FileSystem.get(sc.hadoopConfiguration)

  def create(filePath:String)={
    try{
      fs.create( new Path(filePath))
      println("New File Created Successfully..")
      log.info("New File was Created Successfully")
      fs.close()
    }catch {
      case e:Exception =>  { println("We are Getting the Exception While Creating the File"); log.error("We are Getting the Exception While Creating the File") }
    }
  }

  def writeFile(filePath:String ,data:Array[Byte] )={
    val output = fs.create(new Path(filePath))
    output.write(data)
    println("Writer have been Closed")
    log.info("File Write was Created Sucessfully")
    fs.close()
  }

  def readFile(filePath:String )= {
    for (line <- Source.fromFile(filePath).getLines) {
      println(line)
    }
  }

  def getInfo(srcFilePath:String , methodName:String) = methodName match {

    case "getBlockSizes" |"getblocksizes" 		=> {
                                      val block = fs.getBlockSize(new Path(srcFilePath))
                                     println( " Block Informations is as of below \n "+ block)
  }
    case "getDefaultBlockSize" => {
                                    val defBlock = fs.getDefaultBlockSize(new Path(srcFilePath))
                                    println( " Default Block Informations is as of below \n "+ defBlock )
  }
    case "getFileChecksum"     => {
                                    val fileCheck = fs.getFileChecksum(new Path(srcFilePath))
                                    println( " File CheckSum \n "+ fileCheck )
  }

    case "getFileStatus"        => {
                                    val fileCheck = fs.getFileStatus(new Path(srcFilePath))
                                    println( " File CheckSum \n "+ fileCheck )
  }
    case "getReplication"        => {
                                    val repFactor = fs.getReplication(new Path(srcFilePath))
                                    println( " File Replication Factor is  \n "+ repFactor )
  }
  }

  def createFolder(folderPath:String) = {
    val location = new Path(folderPath)
    if(!fs.exists(location)){
      println("Location is not available \n we are creating the Folder")
      fs.mkdirs(location)
      log.info("New Folder was Created Sucessfully")
    }
  }

  def removeFile(filePath:String) ={
    val location = new Path(filePath)
    if (!fs.exists(location)) println("File Is not available")
    else {

      fs.delete(location,true)}
    log.info("Files were deleted Sucessfully")
  }
  def copyFromLocalOperation(srcFilePath:String , destFilePath:String)= {
    fs.copyFromLocalFile(new Path(srcFilePath),new Path(destFilePath))
    println("File has been copied from local to the Cluster")
    log.info("File has been copied from local to the Cluster")
  }
  def copyToLocalOperation(srcFilePath:String , destFilePath:String)= {
    fs.copyToLocalFile(new Path(srcFilePath) ,new Path(destFilePath) )
    println("File has been copied from Cluster to the Local")
    log.info("File has been copied from Cluster to the Local")
  }
  def setReplication ( filePath :String , num:Short) ={
    fs.setReplication(new Path(filePath) , num)
  }


}













