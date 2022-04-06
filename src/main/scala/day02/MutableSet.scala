package day02

import scala.collection.mutable.HashSet

/**
  * 可变的set
  */
object MutableSet {
  def main(args: Array[String]): Unit = {
    var set1 = new HashSet[String]()
    //添加元素
    set1 += "hello"
    set1.add("world") //等价+=
    set1 ++= HashSet("hello","scala") //添加set集合
    println(set1)

    //更新 (没有指定角标) 添加 +  删除
    set1.add("hi")
    set1.update("hello",false)
    println(set1)

    //删除
    set1 -= "scala"
    set1.remove("world")
    println(set1)

    val set2 = HashSet(1,3,5,7,9)
    set2 --= HashSet(1,3,5)  //删除集合
    println(set2)

    //取值
    println(set2(1)) //判断1是否存在

    /**
      * 可变的set使用两种方式，new HashSet() 或者 HashSet()
      * += ：添加单个元素
      * ++= ：添加集合
      * -
      * -- : 删除集合
      *
      * 取值：不能取指定元素
      * apply(n) : 判断是否有n元素
      * set(n)  : 判断是否有n元素
      */

  }
}
