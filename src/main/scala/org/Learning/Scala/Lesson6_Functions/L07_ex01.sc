val zones = java.util.TimeZone.getAvailableIDs()

val city = zones.map(s => s.split("/")).filter(a => a.length > 1).map(a => a(1))

city.grouped(10).toArray.map( a => a(0))


def concatt(src:Seq[String],sep:String) = {

  src.reduceLeft( (x,y) => x+sep+y)
}

concatt(Array("Mary" , "had" ,"a" ,"chocolate"), " ##")

( 1 to 10).reduceLeft( _ + _)

//Factorial n!
def fact(n:Int):Int = {
  if ( n==1) 1
  else{
    println("n value is %d and n-1 value is %d".format(n,n-1))
    n* fact(n-1)
  }
}

fact(5)


//General Way to Find the 2 Poer N
def pow (a:Int , n:Int) = {

  (1 to n).map( x => a ).reduceLeft(_ * _)

}

pow(2,5)




