
val a = new Array[Int](10)

// if we want to fill the array

for( i <- 0 until a.length) a(i) = i*i
a

// Traverse the elements in the Array

for(ele <- a ) println(ele)

import scala.collection.mutable.ArrayBuffer

val b = new ArrayBuffer[Int]

b += 1
b += (1,2,4,5)
b ++=Array(55,66)

val story =  ArrayBuffer("Rocky" ,"has","The","world","title")
story += "then"
story.remove(0)
story.insert(0,"Cena")
story


// Conversion between Array and ArrayBuffer

val goodStory = story.toArray
goodStory.toBuffer


// In Scala we mormally transform one array into Another

val e = Array(1,2,3,4,5,6,7,88,9,10)

for ( ele  <- e) yield ele*5

// Filter the results we nned to get only odd Numbers

for (ele <- e  if ele %2 !=0) yield ele

// Common Array Operations

val newResu = Array(1,2,32,4,5)
newResu.sum
newResu.max
newResu.sorted
newResu.reverse

// if we want to print the array

newResu.mkString("@")
newResu.mkString("^","--","^")


// Working with Maps

val scores = Map("Messi" ->250 ,"ronoldo" -> 248 , "Esak" -> 200)
//scala.collection.immutable.Map[String,Int]

// these are immutable map if we wnat to need mutable map  we need to declare as below

val mscores = scala.collection.mutable.Map("rock" -> 10 , "cena" -> 16 ,"flair" -> 18)

// accessing the map values

mscores("rock")
//mscores("esak")

// so we prefer the get or else method
mscores.getOrElse("esak",0)
mscores.getOrElse("esak",-1)

//  navigating to the map

for((k,v) <- scores ) println(k + "has the value of "+v)


for ( (k,v)<-scores ) yield (v,k)

// Getting all the keys and Values

scores.keySet
scores.values


// Tuples

val tup = (1,1.23,"Esak")
// access the variables in th tuples
tup._2
tup._1
// tupleas are one based which the starting point starts from the point 1
val (_ , sec , thr) = tup













