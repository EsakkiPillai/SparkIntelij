// Partition and Zip

"Rocko Whats Up Buddy".partition(_.isUpper)
"ip address is 10.20114.255".partition(_.isDigit)
val num  = scala.collection.mutable.ListBuffer(1,2,-3,4,-5,6,-7)
val (neg,pos) =num.partition(_ < 0)
val result = pos
result += neg(0)
result

val symbols = List("<","-",">")
val n = List(2,10,2)
val sysmbolresult = symbols.zip(n)

// we are priting the results as follows

for(ele <- sysmbolresult) print(ele._1*ele._2)





