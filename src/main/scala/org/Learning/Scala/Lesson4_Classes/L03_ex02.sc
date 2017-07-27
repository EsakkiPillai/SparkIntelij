
class timeex2(h:Int ,m:Int) {

  if(h<0||h>24||m<0||m>60) throw new IllegalArgumentException

  private var minuteSinceMidNight = h*60+ m

  def this(h:Int) ={
    this(h,0)
  }
  def hour = minuteSinceMidNight /60
  def minutes = minuteSinceMidNight % 60

  def minutes_= (newValue:Int)  {
    if(newValue<0 || newValue>=60)throw new IllegalArgumentException
    minuteSinceMidNight = hour *60 + newValue
  }
  override def toString: String = "time("+hour+"::"+minutes+")"

  def before (other:timeex2) = minuteSinceMidNight < other.minuteSinceMidNight


}

val noon = new timeex2(4)
val mrg =new timeex2(7,45)

noon.minutes =(56)

noon



