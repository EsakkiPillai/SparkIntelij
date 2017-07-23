/*
 In Scala Every Thing is Object
++ -- scala Doesn't have these Operators we can simulate the same using =+ method
Apply() is aspecial method for this method we don't need to specify the method name
 "hello.apply(4) ==> "hello"(4) both are Same
 */

1 to 10  // This will Create A Rangge of Numbers from 1 ,2,3,4,5,6,7,8,9,10

// Everything in Scala is Object so we can rewrite the above statement as below

1.to(10)

// Both of them Produce Same Value. The Above method of Writing is called infix Notation which means if a method has only one parameter then we can omit the paranthesis and we can rewrite 1.to(10) as  1 to  10


// val means immutable  we cant reassign any value to the variable
// val a = 10 a -20 will throw the compiler exception
//we have to declare the value at the time of installiation , if we dont what value we are goint to maitain throughout thr program for immutability
// and var means mutable and we can reassign the value to the variable
var response=10
response =11
//response ="Esakki"

// For a Var variable we can reassign the variable with the same type but we cant reasign the variable with some other data type
// as above we are reassign a String variable "Esakki" to the int var



// we have to use val in all the situation we have to avoid var as much as possible

// import scala/math._ here _ means we are importing all the classes inside the scala.math packages  in java we have to use *
// in scala there is no need to load the import statement at the begining of the line as like of java
// Scala we can import the line in amy where , after that line we can use the classes which we import


// there are no primitive data types in Scala all of them are Classes
//Semicolons are Optional

val answer = 5* 5
val s = "esakki"

// We are not defining any data type while declaring these val variables scala automatically infer these data type and use it
// val s = "esakki" scala automatically identifies as String  s: String = esakki but when we declare a variable with null we have to specify the data type externally lije below

val n:String = null

// we can use big number to store larger variables
val b :BigInt = 147852

b*b*b*b

// Basic thumb rule is whenever we use the method as a accessor we dont need to specify the paranthesis
// if a method act as a mutatir then we need to specify the paranthesis

"hello".distinct
"hello".length






