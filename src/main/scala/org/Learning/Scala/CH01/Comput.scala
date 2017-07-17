package org.Learning.Scala.CH01

/**
  * Created by etpil on 7/17/2017.
  * we are going to compute computation from  the  Below ncr = n!/( (n-r)! * r1)
  */
object Comput {
// Created a Recursive Which calls Itself until it  reaches 1 so n! = n * n-1 * n-2 ..* 1
  def fact(i:Int):Int = {
    if (i==1)
      1
    else
      i * fact(i-1)

  }

  def comp(n:Int,r:Int) = {

    fact(n) / (fact(n-r) * fact(r) )
  }

  //creating the Main Function

  def main(args: Array[String]): Unit = {
    //we are defining the argumets at runtime Since these are String we are Type Casting it into INT
    val n = args(0).toInt
    val r = args(1).toInt
    println(comp(n,r))


  }
}
