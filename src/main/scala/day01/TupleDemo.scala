package day01

/**
  * 映射实则是key-value的对偶元组
  *
  * 对偶元组中的元素可以任意个，类型也可以任意
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    //元组的创建：使用()括起来的元素，元素与元素之间使用,分割，元素类型个数任意
    val t1 = ("qianfeng","hello","world",123,20.0,26.0f)
    val t2 = (("chinese",90),("math",99),"hadoop",(1,2,3))
    val t3,(a,b,c) = ("深圳","硅谷","gp1801")
    //访问元组
    println(t1._1)
    println(t2._4._2)
    println(t3._3,a)
    println(t3.productElement(1))
    //不能直接循环tuple，需要转换成Array
    for (i <- Array(t3)){
      println(i)
      println(i._3)
    }

    //修改元组的元素？？？
  }
}
