package day02

/*
方法：
基本格式 def/val 方法名(参数列表)()[:返回类型]={方法体}
scala中允许方法嵌套，方法中再写方法
 */
object FunctionDemo {
  def main(args: Array[String]): Unit = {
    //定义有参数的
    def add(x:Int,y:Int):Int = x + y
    //定义多参数列表
    def addMutipleParm(x:Int,y:Int)(a:Int):Int = (x + y)*a
    //定义一个无参的方法，无参方法可省略掉参数列表,
    def getName:String = System.getProperty("user.name")
    //
    def getName1():String = System.getProperty("user.name")
    //定义没有返回值类型
    def getNoValueType = {
      1000.00
    }
    var i = 0
    def getNoValueType1: Unit ={
      i = 10
    }
    def squat(r:Double): Double ={
      val squart = r * r
      squart * 3.14
    }

    /*def squat(r:Double,default:Double)={
      val squart = r*r
      if(default == 0)
        squart * 3.14
      else
        squart * default
    }*/

    //调用方法
    println(add(10,20))
    println(addMutipleParm(10,20)(30))
    println(getName)
    println(getName1())
    println(getNoValueType)
    println(getNoValueType1)
    println(squat(2))

    /**
      * 注意：
      * 方法的返回值类型可以不写，不写scala会自动根据代码块的最后一行语句进行推断
      * 方法默认使用方法体中的最后一行语句进行返回，一般不推荐使用return返回，但也可以使用其返回，容易导致推断失效
      * scala中的方法是不能重载
      * scala中的方法允许多参数列表
      * scala方法中没有返回值，则返回类型是Unit
      */
  }
}
