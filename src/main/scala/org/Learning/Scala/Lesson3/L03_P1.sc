// Removing all the negative number except First negative number from the List

import scala.collection.mutable.ArrayBuffer
val num = ArrayBuffer(1,2,5,6,-1,2,3,3,-4,3,-6,99,3,-33)

val negindexes = for(i <- 0 until num.length if(num(i)< 0)) yield i
val indexestoRemove = negindexes.drop(1)
for(i <- indexestoRemove.reverse) num.remove(i)
num

def removeneg (b :ArrayBuffer[Int]) ={

  val index = (for(i <- 0 until num.length if num(i) < 0) yield i ).drop(1)
  for( i <- index.reverse) num.remove(i)
  num
}

removeneg(num)

//Better scala Program will be using val

 def removeneg2 (b:ArrayBuffer[Int]) ={

   val index = (for(i <- 0 until num.length if num(i) < 0) yield i ).drop(1)
   val numrenew =for( i <- 0 until num.length if (!index.contains(i)) ) yield num(i)
    numrenew
 }
//changing the Array Buffer to Array
removeneg2(num).toArray




