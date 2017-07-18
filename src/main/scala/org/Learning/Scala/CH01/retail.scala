package org.Learning.Scala.CH01

/**
  * Created by etpil on 7/18/2017.
  * We are Creating the Class and Constructor
  * We are Overriding toString Method
  * we use require method to check for Object Conditions
  */

class Departments(val departmentId:Int , val departmentName :String){
  println("Start of Constructor ")
  println("Department Id is \t"+departmentId+"\t and its Name is "+departmentName)

  /*
  we can add the Constraints to the Class object while Creating it
  we need to use require method to check the Values
   if the values are not satisfied it throws java.lang.illegalArgumentException
   Exception in thread "main" java.lang.IllegalArgumentException: requirement failed

   we can add the Custom Message as well
   */
  //require(departmentId>0)
  require(departmentId>0,"DepartmentId should be Greater than Zero")

  /*
  Exception in thread "main" java.lang.IllegalArgumentException: requirement failed: DepartmentId should be Greater than Zero
	at scala.Predef$.require(Predef.scala:224)
	at org.Learning.Scala.CH01.Departments.<init>(retail.scala:21)
	at org.Learning.Scala.CH01.retail$.main(retail.scala:39)
	at org.Learning.Scala.CH01.retail.main(retail.scala)
   */

  /* we have to specify the OVERRIDE keyword to override any Method
      ToString Method Always return  a String
   */
  override def toString: String = {

    println(" we are Overriding the ToString Method")
    departmentId+"::"+departmentName
  }

   def setPrinter(floor:String) ={
    println("We are Setting the Printer in "+floor+"Floor")
  }
  /* To Create Multiple Constructor we have to use This Keyword we have to satisfy the base constructor
    First LIne of the Code should be Default Constructor
    this(departmentId:Int) will be treated as public Departments(int)
   */

  def this (departmentId:Int) ={
     this (departmentId , "BENCH")
    // add Additional Fuctionality
    println("Additional Non Default Constructor")
  }
  println("End of Constructor ")
}
object retail {

  def main(args: Array[String]): Unit = {

    val d= new Departments(1,"Esak-HR")
    val b  = new Departments(3)
    println(d)
    println(b)

    // we want to Override  the base calss toString Function , when ever we create the Object address is Printed
    // val d1 = new Departments(0,"Eee")

  }
}
