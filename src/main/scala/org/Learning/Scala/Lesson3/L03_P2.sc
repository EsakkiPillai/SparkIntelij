import java.net.URL
import java.util.Scanner
// WordCount Exercise

// read a file and yields the frequency of the Word

val in = new Scanner(
  new URL("http://http://horstmann.com/presentations/livelessons-scala-2016/alice30.txt")
    .openStream())
val count = scala.collection.mutable.Map[String,Int]()
//var count =Map[String,Int]()
while (in.hasNext()){
  val word =in.next()
  count(word) = count.getOrElse(word,0) +1
  //count = count + (word -> (count.getOrElse(word,0) +1))
}

count("Alice")
count("the")
