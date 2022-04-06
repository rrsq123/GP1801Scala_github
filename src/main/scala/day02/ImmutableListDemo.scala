package day02

import scala.collection.mutable.ListBuffer

/**
  * scala中的集合
  * scala集合大致为三类：Seq序列（list）、Map映射、Set集。所有的集合都扩Iterable特质
  * list也分可变和不可变两种,默认创建不可变，
  */
object ImmutableListDemo {
  def main(args: Array[String]): Unit = {
    //不可变的list
    val list0 = List(11,12)
    val list1 = List(1,2,3,4,5,6)
    var list2:List[String] = List("hadoop","spark","flink")

    println(list2)
    //在list2中添加元素
//    list2 += "python"
    //从左往右连接集合的信息
    val list3 = list2 :: list1
    val list4 = "tensflow" :: list2
    val list5 = "tensflow" +: list2
    val list6 = list2.::("tensflow") //等价于list4
    val list7 = list2.+:("tensflow") //等价于list5
    println(list3,list3.size)
    println(list4)
    println(list5)
    println(list6)
    println(list7)

    //将信息添加到集合后面
    val list8 = list2 :+ "sklearn"
    val list9 = list2.:+("sklearn")
    println(list8,list9)

    //添加到
    val list10 = list2 :: list1
    val list11 = list2 ++ list1

    println(list10,list11)

    val list12 = list2 ::: list1 //contact() 可以连接两个或者多个list
    val list13 = list2 .:::(list1) //contact() 可以连接两个或者多个list
    println(list12)
    println(list13)
    /**
      * ::
      * +:
      * :+
      * li++li
      * :::
      */
    //取指定的元素
    println(list1.apply(1))
    println(list1.head)
    println(list1.last)
    println(list1(1))
    println("aaa"+list1.take(2)) //取前几个元素
    for(i <- list1) print(i)

    /**
      * 不可变的使用List获取
      * 连接符号 ：
      * ::
      * +:
      * :+
      * li++li
      * :::
      * 取值：
      * apply()
      * li()
      */

    //可以用ListBuffer
    val list16 = new ListBuffer[Int]()
  }
}
