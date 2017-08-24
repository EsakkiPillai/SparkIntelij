package com.Spark.Learnings.SparkCore

import com.typesafe.config.ConfigFactory
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

/**
  * Created by etpil on 8/21/2017.
  */
object RevenuePerProductForMonth {

  def main(args: Array[String]): Unit = {

    val inputPath = args(1)
    val outPutPath = args(2)
    val localInputPath = args(3)
    val month = args(4)

    val props = ConfigFactory.load()

    val env = props.getConfig(args(0))

    val sc = new SparkContext( new SparkConf().setAppName("Revenue Per Product Per Month ").setMaster(env.getString("executionMode")))
    val fs = FileSystem.get(sc.hadoopConfiguration)
    if(!fs.exists(new Path(inputPath))) {
        println("InPut FIles are Not Available")
    }else{
      if(fs.exists(new Path(outPutPath))){
          fs.delete(new Path(outPutPath),true)
      }
    }

    val orders = inputPath+"/orders"
    val currentMonth = sc.textFile(orders).filter( rec => rec.split(",")(1).contains(month)).map(x => ( x.split(",")(0).toInt ,1) )


    val order_items = inputPath+"/order_items"
    val revenueByProduct = sc.textFile(order_items).map(order_items => {

                                                                        val oi = order_items.split(",")
                                                                        (oi(1).toInt ,(oi(2).toInt,oi(4).toFloat))
                                                                        }).join(currentMonth).map( rec => rec._2._1).reduceByKey(_ +_)



    val products = Source.fromFile(localInputPath  + "/products/part-00000").getLines()
    sc.parallelize(products.toList).
      map(product => (product.split(",")(0).toInt, product.split(",")(2))).
      join(revenueByProduct).
      map(rec => rec._2.productIterator.mkString("\t")).
      saveAsTextFile(outPutPath)

  }
}
