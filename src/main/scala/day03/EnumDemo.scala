package day03

/**
  * scala中的枚举
  * 1、枚举对象需要使用object来修饰，不能是class
  * 2、必须继承Enumeration
  *
  */
object EnumDemo extends Enumeration {
  val HADOOP = Value("hadoop")
  val SPARK = Value("spark")
  val FLINK = Value("flink")
}

object EnumDemoTest{
  def main(args: Array[String]): Unit = {
    println(EnumDemo.FLINK)
    println(EnumDemo.HADOOP)
    println(EnumDemo.SPARK)
    println(EnumDemo.values)
    println(EnumDemo.apply(1))
    println(EnumDemo.withName("spark"))  //获取枚举

    //遍历枚举
    EnumDemo.values.foreach(f => print(f+" "))

    //返回枚举？？
  }
}
