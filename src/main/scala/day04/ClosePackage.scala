package day04

/**
  * scala中的闭包：
  * 闭包是指一个函数的返回值依赖于申明在外的变量，称之为闭包函数。
  */
object ClosePackage {
  def main(args: Array[String]): Unit = {
    //定义普通方法
    def f1(i:Int)={i*10}
    //定义闭包函数
    val close:Int = 10
    val f2 = (i:Int) => i * close

    println(f1(10))
    println(f2(10))
  }
}
