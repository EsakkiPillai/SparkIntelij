class point (val x:Double,val y :Double){
  def this() { this(0,0)}
  println("Welcometo the Point(%f,%f)".format(x,y))
  def move (dx:Double ,dy:Double) = new point(x+dx , y+dy )
  def distanceFromOrigin =  math.sqrt(x*x + y*y)
  override def toString = f"${x} ,${y}"
}

val p = new point(3,4)  //Tis get printed by the toString Method  p: point = 3.0 ,4.0
p.move(10,20)  //res0: point = 13.0 ,24.0
p.distanceFromOrigin
p.x    //3.0
p.y    //res3: Double = 4.0


1 to 10 map (3 * _ ) filter (_ % 5 ==2)

(1 to 10).map (3 * _ ).filter (_ % 5 ==2)