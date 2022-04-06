package day01

import scala.collection.mutable
/**
  * 可变的map
  */
object MutibaleMap {
  def main(args: Array[String]): Unit = {
    val map1:mutable.Map[String,Int] = mutable.Map[String,Int]()
    val mapp = new mutable.HashMap[Int,mutable.StringBuilder]()
    //添加元素
    map1 += "chinese"->90
    map1 += (("english",100),("math",99))
    println(map1)

    //更新
    map1.update("chinese",100)
    map1.update("chinese111",100)
    map1("math") = 60
    println(map1)

    //删除
    map1 -= "chinese"
    map1 -= ("chinese111")
    map1.remove("math")
    map1 -= ("222") //删除没有key，不报异常
    println(map1)

    //获取指定的key
    println(map1.get("english1"))
    println(map1.getOrElse("english","0"))
    println(map1.apply("english"))
    println(map1("english"))
    //如下的模式匹配，类似于getOrElse()
    map1.get("english") match {
      case None => println(0)
      case Some(v) => println(v)
    }
  }
}
