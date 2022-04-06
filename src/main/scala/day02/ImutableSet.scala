package day02

import scala.collection.immutable.HashSet

/**
  * 不可变的set
  */
object ImutableSet {
  def main(args: Array[String]): Unit = {
    val set1 = new HashSet[String]//("set","hadoop")
    //添加元素
    val set2 = set1 + "hello" //不可变的会生成的新的set
    println(set1)
    println(set2)

    //删除
    val set3 = set2 - "hello"  //会生成新的
    println(set2)
    println(set3)

    //定义一个set
    val set4 = HashSet(1,2,3,4,5,6)
    val set5 = HashSet(1,2,6,7,8,9)

    val set6 = set4 ++ set5 //会生成新的
    println(set6)
    val set7 = set6 -- set5
    println("set7:"+set7)

    //取值
    println(set6.apply(2)) //有该值为true
    println(set6.take(2))
    println(set6(2))  //有就是true
    println(set6.tail)

    for(i <- set6) print(i+" ")
    set6.foreach(f=>print(f+" "))

    /**
      * 不可变的set使用两种方式，new HashSet() 或者 HashSet()
      * + ：添加单个元素 生成新的
      * ++ ：连接集合 生成新的
      * -
      * -- : 删除集合 生成新的
      *
      * 取值：不能取指定元素
      * apply(n) : 判断是否有n元素
      * set(n)  : 判断是否有n元素
      */
  }
}
