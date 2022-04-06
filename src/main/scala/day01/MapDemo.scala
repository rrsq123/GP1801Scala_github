package day01

import scala.collection.immutable.HashMap

/**
  * scala中把map叫做映射
  * 1、map中的key是唯一
  * 2、通过key取值
  * 3、map也叫haseTable
  * 4、map也分别有可变Mutibale和immutibale;区别是不可变的不能修改其值，可变的可以
  * 5、默认创建的map为不可变
  * 6、如果创建可变map，需要引入mutibale
  */
object MapDemo {
  def main(args: Array[String]): Unit = {
    //定义map 元素组成形式:key->value 或者 (key,value)
    val map1 = Map("chinese"->80,"math"->99,"english"->60)
    val mapp = new HashMap[Int,String]()
    println(map1)
    //更新值
    val map2 = map1.updated("chinese",100)
    println(map2)
    map2.filter(t=>t._2 > 90)  //过滤

    //遍历
    map2.foreach(f=>println(f._1+":"+f._2))

    //使用元组方式来定义map
    var map3 = Map(("chinese",90),("math",100),("english",60))
    println(map3)
    map3.updated("chinese",66)
    println(map3)

    //添加键值对
    map3 += "computor"->100
    map3 += ("sport"->100,"music"->99)
    map3 += (("cc",99))
    map3 += (("cc",98),("aa",100))
    println(map3)

    //删除
    map3 -= "cc"
    map3 -= ("music","english")
    println(map3)

    //取对应key的值
    println(map3.get("music"))
    println(map3.getOrElse("music","null")) //没有对应的key给默认
    val allkeys = map3.keySet //取所有的keys
    val allvalues = map3.values //取所有的values
    println(allkeys)
    allvalues.foreach(f=>println(f))
    println(allvalues)
    //循环map中的所有的key-value
    for((k,v) <- map3)
      println(k+":"+v)

    /**
      * 不可变的map，可以进行增删key-value，修改不能
      */
  }
}
