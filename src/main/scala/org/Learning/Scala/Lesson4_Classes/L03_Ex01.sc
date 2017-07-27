class time(val hours:Int , val minutes:Int) {

  def this(hours:Int) = {
    this(hours,0)
  }
  if(hours < 0 || hours > 23 ||minutes < 0 || minutes >59) throw new IllegalArgumentException
  override def toString: String = "Time("+hours +":"+ minutes+")"

  def before(other :time):Boolean ={
    val other_MIinutes = (other.hours*60) + other.minutes
    val currentminutes = (this.hours*60) + this.minutes
    val  balance = currentminutes - other_MIinutes

    if(balance >0) false else true
  }

  def beforesimple(other:time) = hours < other.hours || hours == other.hours && minutes < other.minutes

}

val a = new time(3,45)
val b = new time(4,34)
a.beforesimple(b)

val noon = new time(12)


// Exercise 2 UniformAccess 