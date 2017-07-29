/*  Set is iterable which contains unique values there wont be any duplicate values
eventhough we access the set eith the index it always return diff values

Array if we randomly access the elments and perform actions on it we go for Array
List  if the collection has length and index and if we eant to access the entire collection then we go for List
 set if the collection should nt contain any duplicate values then go for set
 map  if we nned to have some other value other than int is as index then we go for Map which is a key value pair

 */


//val check = Array(1,2,3,4,5)
//check(4) = 2
// check

// as seen below  val check belongs to the set collection each time we call the check it returns values in the different ordering
val check = Set(1,2,3,4,5)
check(4)
check
//
//scala> val ms  = scala.collection.mutable.Set(1,25,45,5,66,25,65,0)
//ms: scala.collection.mutable.Set[Int] = Set(0, 66, 45, 1, 5, 25, 65)
//
//scala> ms
//res5: scala.collection.mutable.Set[Int] = Set(0, 66, 45, 1, 5, 25, 65)
//
//scala> ms.update
//def update(elem: Int,included: Boolean): Unit
//
//scala> ms.update(100,true)
//
//scala> ms
//res7: scala.collection.mutable.Set[Int] = Set(0, 66, 45, 1, 100, 5, 25, 65)
//
//scala> ms.update(100,false)
//
//
//scala> ms
//res9: scala.collection.mutable.Set[Int] = Set(0, 66, 45, 1, 5, 25, 65)

//scala> ms.remove
//def remove(elem: Int): Boolean
//
//scala> ms.remove(0)
//res10: Boolean = true
//
//scala> ms
//res11: scala.collection.mutable.Set[Int] = Set(66, 45, 1, 5, 25, 65)
//
//scala> ms += 155
//res12: ms.type = Set(66, 45, 1, 5, 155, 25, 65)
//
//scala> ms -= 155
//res13: ms.type = Set(66, 45, 1, 5, 25, 65)
//
//scala> ms ++= Set(500,501,503)
//res14: ms.type = Set(66, 45, 1, 503, 5, 500, 25, 501, 65)
//
//scala> ms
//res15: scala.collection.mutable.Set[Int] = Set(66, 45, 1, 503, 5, 500, 25, 501, 65)

// we can create the map with the "->" and () symbol
//scala> val mp = Map ( 1->"Hello" ,(2,
//  | "World") , 3->"Esak" )
//mp: scala.collection.immutable.Map[Int,String] = Map(1 -> Hello, 2 -> World, 3 -> Esak)
//
//scala> mp
//res17: scala.collection.immutable.Map[Int,String] = Map(1 -> Hello, 2 -> World, 3 -> Esak)


//scala> mp
//res18: scala.collection.immutable.Map[Int,String] = Map(1 -> Hello, 2 -> World, 3 -> Esak)
//
//scala> mp(1)
//res19: String = Hello
//
//scala> mp(78)
//java.util.NoSuchElementException: key not found: 78
//at scala.collection.MapLike$class.default(MapLike.scala:228)
//at scala.collection.AbstractMap.default(Map.scala:59)
//at scala.collection.MapLike$class.apply(MapLike.scala:141)
//at scala.collection.AbstractMap.apply(Map.scala:59)
//... 32 elided
//
//scala>

// Map as  a Collection


case class Order(
                  orderId :Int ,
                  orderDate :String ,
                  orderCustomerId:Int ,
                  orderStatus:String )


val mp = Map (
  (1,Order(1,"2017-20-01",100,"COMPLETED")),
  (2,Order(2,"2017-20-01",200,"COMPLETED")),
  (3,Order(3,"2017-20-01",300,"COMPLETED")),
  (4,Order(4,"2017-20-01",400,"CLOSED"))
)
// getting the values based on the Keys

mp.get(1)
mp.get(2)
mp.get(3)

//// Some Mao Functions
//Look up   => apply getorelse  contains isDefined
//SubCollection Procedure keyset  keys keysIterator values valuesIterator
//Transformation  => FilterKeys mapValues


mp.contains(3)
mp.getOrElse(1,Order(0,"xxx",0,"XXX"))
mp.getOrElse(7,Order(0,"xxx",0,"XXX"))

// Gettingg all the Keys

mp.keys
mp.keySet
mp.keysIterator.toList
mp.values
mp.valuesIterator.toList


// Tranformation

mp.filterKeys( x => x<3)
mp.mapValues( o => (o.orderDate,o.orderStatus))









