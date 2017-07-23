package org.Learning.Scala.CH05

/**
  * Created by etpil on 7/18/2017.
  */

/*
If the object and class are having samename then the object is called as companion object to that class
there were special permissions given to the object
        1) It can access the Private members of the class
 To check the Metadata use :javap in repl
         1) :javap -p departments (class)
         2):javap -p departments$ (objects)
 Apply is a very special Method val dept = Department.apply(1,"HR") is equivalent to val dept = Department(1,"HR")

 */

class CompDemo(val l :Int) {

  private def setPrinter(floor:String) ={
     println("We are Setting the Printer in "+floor+"Floor")
  }
}
object CompDemo {
  def printer() = {
    val c = new CompDemo(10)
    c.setPrinter("5")
  }

}

object runner {

  def main(args: Array[String]): Unit = {

    CompDemo.printer()

  }
}
