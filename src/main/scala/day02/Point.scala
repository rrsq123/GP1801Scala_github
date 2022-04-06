package day02

/**
  *
  * scala中类默认有一个空的主构造器，同时也可以写一个有参的主构造器
  */
class Point(var x:Int,var y:Int) {

  def move(dx:Int,dy:Int)={
    x = dx + x
    y = dy + y
  }

  override def toString: String = {
    s"($x,$y)"
  }
}

object Point{
  def main(args: Array[String]): Unit = {
    //获取Point对象
    val point = new Point(10,20)
    println(point)
    point.move(1,2)
    println(point)
    println(point.x)
    println(point.y)
  }
}
