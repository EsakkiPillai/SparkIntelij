package org.Learning.Scala.Application_Jdbc

/**
  * Created by etpil on 7/31/2017.
  * mysql -u hr_ro -h nn01.itversity.com -p   itversity
  *
  * We have to print like fname lastname comission amt (amount /  NotElligible )
  *
  * select  first_name,last_name, salary*commission_pct from employees;  portno 3306
  *
  *
  * running the Application in sbt
  *   sbt package  will create a Paackages in the Target Folder
  *   sbt "run-main org.Learning.Scala.Application_Jdbc.CommisionAmount dev"

  */
import java.sql.DriverManager
import com.typesafe.config._
case class EmployeesCommission(
                            first_name:String ,
                            last_name:String  ,
                            salary:Double     ,
                            commission_pct:Double
                            ){

  override def toString: String = s"first_name"+first_name+": Last Name"+last_name+": Commossion_amount-"+getCommission()

  def getCommission():Any = {
    if(commission_pct == 0) "Not Elligible"
    else commission_pct * salary
  }
}
object CommisionAmount {

  def main(args: Array[String]): Unit = {
    println("We are going to establish a Conection with JDBC")
    val env = args(0)

    val conf = ConfigFactory.load()
    val prop: Config = conf.getConfig(env)

    val driver = prop.getString("driver")
    val host = prop.getString("host")
    val port =prop.getInt("port")
    val db = prop.getString("db")
    val url = "jdbc:mysql://"+host+":"+port+"/"+db
    println("we are connecting to "+url)

    val username = prop.getString("username")
    val password = prop.getString("password")


    Class.forName(driver)
    val connection = DriverManager.getConnection(url,username,password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT first_name, last_name, " +
      "salary, commission_pct FROM employees")
 // Traditional Approach
//    while (resultSet.next){
//
//      val e = EmployeesCommission(resultSet.getString("first_name"),
//            resultSet.getString("last_name"),
//              resultSet.getDouble("salary"),
//              if(resultSet.getDouble("commission_pct").isNaN) -1.0 else resultSet.getDouble("commission_pct"))
//            println(e)
//    }


      //  Functionl Approach


    Iterator.continually((resultSet.next(),resultSet)).takeWhile(_._1). map(r => {
      EmployeesCommission(
        r._2.getString("first_name"),
        r._2.getString("last_name"),
        r._2.getDouble("salary"),
        r._2.getDouble("commission_pct")
      )
    }).
      toList.
      foreach(println)

  }

}
