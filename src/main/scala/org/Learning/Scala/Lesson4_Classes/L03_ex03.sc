//operators


class timeex3(val hours :Int  ,val minutes:Int){

  if(hours < 0 || hours > 23 ||minutes < 0 || minutes >59) throw new IllegalArgumentException
  override def toString: String = "Time("+hours +":"+ minutes+")"

  def -(other:timeex3) = (hours*60+minutes)-(other.hours*60+other.minutes)
  def <(other:timeex3) = this - other < 0

}

object timeex3 {

  def apply( hours:Int ,minutes:Int) = new timeex3(hours ,minutes)
  def apply(hours:Int)= new timeex3(hours,0)

}

timeex3(2,30) - timeex3(3)

timeex3(2,30) < timeex3(3)












