package org.Learning.Scala.CH06

import org.Learning.Scala.CH06

/**
  * Created by etpil on 7/19/2017.
  * We are Creating A Fraction Class and we have to display it as 7/3
  * We are creating the Add Functionality which adds two fractional Numbers 7 2  3 4 7*4 + 2*3 / 2+4
  * Get the Fraction results in Decimal
  * the * plus Function is represented as public Fraction $plus(Fraction)
  */

class Fraction(val numerator :Int ,val denominator:Int) {

  override def toString: String = numerator + "/" + denominator

  def +(f:Fraction) = {

      val num = ((numerator * f.denominator ) + (denominator * f.numerator))
      val den= ( denominator * f.denominator)
     new Fraction(num,den)
  }

  def result = numerator / denominator.toDouble

  def -(f:Fraction) = {

    val num = ((numerator * f.denominator ) - (denominator * f.numerator))
    val den= ( denominator * f.denominator)
    new Fraction(num,den)
  }

  def *(f:Fraction) = {

    val num = ((numerator *  f.numerator))
    val den= ( denominator * f.denominator)
    new Fraction(num,den)
  }


  def /(f:Fraction) = {

    val num = ((numerator *  f.denominator))
    val den= ( denominator * f.numerator)
    new Fraction(num,den)
  }

}

object Fraction {

  def main(args: Array[String]): Unit = {
    val fractionobj = new Fraction(10,5)
// to gave the Arguments as runtime Arguments
    val newFraction = new Fraction(args(0).toInt,args(1).toInt)
    println("Fraction is "+ fractionobj)
    println("New Fraction is "+ newFraction)
    // Performing the Addition Operation

    println (fractionobj * newFraction )
    println (fractionobj + newFraction )
    println (fractionobj - newFraction )
    println (fractionobj  / newFraction )
  // if the function take one parameter we can remove the Parantheses we can rewrite it as
    // fractionobj + newFraction
  println(" Sum of the Fractions in the Decimal Form ")
  print((fractionobj + newFraction ).result )
  }
}

