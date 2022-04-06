package day02

import scala.collection.mutable.ListBuffer

/**
  * 可变的list
  */
object MutableList {
  def main(args: Array[String]): Unit = {
    //定义可以变的list
    val list1 = new ListBuffer[String]//("hadoop","spark","scala")
    //添加值
    list1 += "tensflow"
    list1.append("hello","world","spark")
//    list1 :: List(11,12)
    list1.appendAll(List("hive","datawarehous")) //注意类型
    println(list1)

    //删除元素
    list1 -= "tensflow"
    list1.remove(1)
    list1.remove(1,2)
    list1.drop(1) //返回新的
    println(list1)

    //修改元素
    list1.update(1,"hive")
    list1(0) = "hadoop"
    println(list1)

    //取值
    list1.appendAll(List("hbase","spark"))
    println(list1(1))
    println(list1.apply(1))
    println(list1.take(1)) //从前往后取多少个
    println(list1.head)
    println(list1.last)
    println(list1.tail) //除第一个

    //使用ListBuffer 来获取，此时可以指定值
    val list2 = ListBuffer(1,2,3,4,5,6)
    //对于不可变的连接符号可用，但是也会生成新的list
    list2 +: list2
    list2 :+ 3
    println(list2)

    /**
      * 使用两种方式获取可变的list，分别是ListBuffer() 或者 new ListBuffer()
      * += .append()  .appendall()
      * -= .remove()
      * li(n)=vallue update()
      * li(n) apply() take() tail() head last
      */
    val seq = Seq(1,2,3,4,5,6)
    println(seq)
  }
}
