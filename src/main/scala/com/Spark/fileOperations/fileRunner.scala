package com.Spark.fileOperations

import org.apache.hadoop.fs.Path

/**
  * Created by etpil on 8/18/2017.
  */
object fileRunner extends fileLevelOperation {

  def operations (methodName:String, srcFilePath:String, destFilePath:String ) = methodName match {
    case "CREATE"  => if (!fs.exists(new Path(srcFilePath)))create(srcFilePath)
    case "Write" 						=> writeFile(srcFilePath,"Hi Welcome to the Programming Language".getBytes())
    case "Read" 						=> readFile(srcFilePath)
    case "getInfo"          => getInfo(srcFilePath,destFilePath)
    case "createNewFolder" 	=> createFolder(srcFilePath)
    case "copyFromLocal" 		=> copyFromLocalOperation(srcFilePath,destFilePath)
    case "copyToLocal" 			=> copyToLocalOperation(srcFilePath,destFilePath)
    case "setReplication" 	=> setReplication(srcFilePath,4)
    case _ => println("Please select the Correct option")


  }
  def main(args: Array[String]): Unit = {

    operations("CREATE","E:\\Workspace_July\\DUMMY\\sample.txt","NA")
    operations("Write","E:\\Workspace_July\\DUMMY\\sampleWrite.txt","NA")
    operations("Read","E:\\Workspace_July\\DUMMY\\Classes.txt","NA")
    operations("getInfo","E:\\Workspace_July\\DUMMY\\Classes.txt","getFileChecksum")
    operations("createNewFolder","E:\\Workspace_July\\DUMMY\\Classes","NA")
    operations("setReplication","E:\\Workspace_July\\DUMMY\\Classes.txt","NA")
  }

}
