package day01

import scala.collection.mutable.ArrayBuffer
/**
  * 变长数组
  */
object VarLengthArray {
  def main(args: Array[String]): Unit = {
    //使用new ArrayBuffer() 定义一个变长的数组
    val arr1:ArrayBuffer[String] = new ArrayBuffer[String]()
    println(arr1)

    //使用ArrayBuffer() 定义一个变长数组，实则使用ArrayBuffer的apply()
    val arr2 = ArrayBuffer()

    //添加元素
    arr1 += "hadoop"
//    arr1(1) = "aaa"
    arr1 += ("hive","spark")
    arr1 ++= ArrayBuffer("hbase","scala") //添加数组
    println(arr1)

    //再指定的位置添加元素
    arr1.insert(1,"cdh")
    arr1.insert(1,"aa","cc")
    arr1.insertAll(1,ArrayBuffer("人工智能","大数据")) //插入数组

    //更新元素
    arr1(1) = "机器学习"  //更新指定的元素
    arr1.update(2,"云计算")

    println(arr1)

    //取指定的元素
    println(arr1(1))
    println(arr1.apply(2))
    println(arr1.take(2))
    //遍历
    for(i<-arr1)
      print(i+" ")
    println()

    //删除
    arr1 -= "hadoop"
    arr1 -= ("机器学习","云计算")
    arr1 --= ArrayBuffer("aa","cc")
    arr1.remove(1) //下标
    arr1.remove(1,2)  //从某个下标开始，移除多少个
    arr1.trimEnd(1) //从后往前移除n个元素
    arr1.trimStart(1)
    println(arr1)
  }
}
