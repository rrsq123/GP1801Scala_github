package day04

/**
  * 偏函数：
  * 被包括{}内没有match来匹配的一组case语句就是一个偏函数.
  * 它是PartialFunction[A,B]的一个实例，A代表输入参数类型,B代表输出值的类型，常用于模式匹配
  * 格式：def 偏函数名称:PartialFunction[A,B] = {case ...}
  */
object PartitalFunctionDemo {
  def main(args: Array[String]): Unit = {
    //定义一个偏函数
    def partial:PartialFunction[String,Int] = {
      case "java" => 1
      case "hadoop" => 2
      case "spark" => 3
      case _ => 0  //默认
    }

    println(partial("hadoop"))

  }
}
