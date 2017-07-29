//Functions
//
//Functions are the first class citizens
//
//what we  can do it with the function
//  call the function
//store the function
//pass a function to another function

import  scala.math._
val num = 14578.25
val fun = ceil(_)

// calling the function
fun(num)
// passing the function ceil to another function map
val s= Array(1.52,1.24,1.02,2.01,2.55).map(fun)
// we can also the pass thr function as anonumys Function in map
val s1 = Array(1.52,1.24,1.02,2.01,2.55).map(x => scala.math.ceil(x))

/* Functions that produce another Function


 */


def mulBy(time:Double) = (X:Double) => time*X
val fquintuple = mulBy(3)
fquintuple(10)

// in the above Functions X is not assigned
// when we write a function and it has a variable which was not specified in the function but from the outside function capture those variables


// Parantheses
Array(1.52,1.24,1.0).map((x:Double) => 4 *x )
// scal acan infer the type Double so we can ignore it
Array(1.52,1.24,1.0).map( (x) => 4 *x)
// since we have one parameter we can ignore the input x parantheses before the function
Array(1.52,1.24,1.0).map( x => 4 *x)
// the above sysntax is quite a good we can reduce it further since x is used only one tim  in the function we can ignore it by saying the _
Array(1.52,1.24,1.0).map(4 * _)


// Currying = turning a function which taks two parameter into a  function which takes one argument

def mul (x:Int,y:Int) = x*y
// and the curried Version
def mulOneatTime(x:Int) =(y:Int) => x*y
// the above statement can be re written in syntactic sugar as
def mulOneAtTime2(x:Int)(y:Int) = x *y

mulOneatTime(3)  //res6: Int => Int = <function1>

mulOneatTime(3) (14)  //res7: Int = 42






