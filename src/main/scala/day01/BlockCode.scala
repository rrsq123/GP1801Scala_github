package day01

/**
  * 块表达式：在{}中的一些列语句称之为一个块，块的最后一行是返回值;
  * 当代码块最后一行是赋值语句，则返回Unit类型()
  */
object BlockCode {
  def main(args: Array[String]): Unit = {
    val x = 0
    var a:Int = -1
    val res = {
      if(x < 0){
        -1
      } else if(x > 0){
        1
      } else {
        a = 0
      }
    }
    println(res)

    //计算距离
    val x0 = 1
    val y0 = 1
    val x1 = 2
    val y1 = 2
    val distance = {
      val dx = x1 - x0
      val dy = y1 - y0
      Math.sqrt(dy*dy + dx*dx)
    }
    println(distance)

    /**
      * 1、块的值是最后一行值
      * 2、如果块最后一行是赋值语句，则返回unit类型()
      * 3、块必须要有一个变量来接收值
      */
  }
}
