package org.Learning.Scala.CH05

/**
  * Created by etpillai on 7/19/2017.
  * When we create a Case Class it extends Serializable and Product
  * no need to give new Keyword
  * it has toString hashcode copy equals method
  * by default it will be val variables
  * after 2.11 there wont be any limitation to the no of input parameters
  * it also have companion object
  */

case class Depar(departmentId :Int ,departmentName :String) {

  override def toString: String = "departmentId is ::" + departmentId +"department Name is ::" + departmentName
}

object caseClassDemo {
  def main(args: Array[String]): Unit = {
    val dept = Depar(1, "HR")
    println(dept)
    println("deptartment ID is" +dept.departmentId)
    println(dept.productArity)
    println(dept.productElement(1))
    dept.productIterator.foreach(print)
  }


}