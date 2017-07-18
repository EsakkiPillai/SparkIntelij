package org.Learning.Scala.CH01

/**
  * Created by etpil on 7/18/2017.
  * We can Create A class as Below
  *
  */
class Departmentssrc( departmentId :Int ,departmentName :String)

/*
if we create the class as above we will get only Constructor ,it has Java Int and Java String
we can create the object ad we cant access member variables
 val d = Departments(1,"HR")
>d.departmetId => will give Some Error like value deparrtmentid is not a member value
  */

class Departmentsbkp(val departmentId:Int ,val departmentName:String)
/*
if we create the class as above  we can access the Member variable,it will create the member variables as well as getter method
 use :javap -p <className>
 val will create a getter Method var creates getter and Setter method
 we can access the member Variables like d.departmentId
 */
object ClassDemo {

  def main(args: Array[String]): Unit = {
    val d = new Departmentsbkp(1,"HR")
    println("DepartmentName is "+d.departmentName)

    println("Object Values are "+d)
/*
  In Scala we have Class Hierarchy ,


 */
    // Ite Above Line Return "Object Values are org.Learning.Scala.CH01.Departmentsbkp@5cb9f472" but we need to Display the  original data so that we have to overwrite the toString metod


  }
}
