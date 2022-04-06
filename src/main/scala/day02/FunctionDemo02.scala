package day02

/**
  * scala中的函数：函数被称为scala中的"头等公民"
  * 基本格式：val/def fun [=(参数列表)] =/=> {函数体}
  */
object FunctionDemo02 {
  def main(args: Array[String]): Unit = {
    //定义一个函数
    val fun1 = (x:Int,y:Int) => x + y //函数不能加返回类型
    val fun2 =(x:Int,y:Int) =>{
      var sum = x + y
      sum * 100
    }
    val fun3 =(x:Int,y:Int) =>{
      var sum = x + y
      sum = 100
    }
    val fun4 = (a:String) => "input code:"+a
    val fun5 = () => 100.00

    //定义一个方法
    def m(oldAge:Int,youngAge:Int) = {
      oldAge <= 18 && youngAge <= 18
    }

    //定义函数
    val f = (oldAge:Int,youngAge:Int) =>{
      oldAge <= 18 && youngAge <= 18
    }

    //定义一个方法
    def m1(oldAge:Int,youngAge:Int):String = {
      val age:Boolean = m(oldAge,youngAge)
      val res:String = if (age) "so young." else "yoxi"
      res
    }
    //定义方法，并使用函数作为参数传递
    def m2(oldAge:Int,youngAge:Int,f:(Int,Int)=>Boolean) = {
      val age:Boolean = f(oldAge,youngAge)
      val res:String = if (age) "so young." else "yoxi"
      res
    }

    val ss = (a:Int,b:Int) => a+b
    val sss = (a:Int,b:Int) => a*b
    def s(a:Int,b:Int,f:(Int,Int)=>Int) = {
//      ss(a,b)  //方法中直接调用函数
      f(a,b)  //使用参数列表中传递过来的函数
    }

    //测试
    println(fun1(10,20))
    println(fun2(10,20))
    println(fun3(10,20))
    println(fun4(" gp1801"))
    println(fun5)
    println(fun5())
    println(m1(20,30))
    println(m2(20,30,f))
    println(s(10,29,ss))
    println(s(10,29,sss))

    //将方法直接转换成函数
    def m3(a:Int,b:Int) = a + b
    val f3 = m3 _  //再方法的名称后面加空格 _
    def m4(a:Int,b:Int,f:(Int,Int)=>Int):Int = {
      a+b+f(a,b)
    }
    println(m4(10,20,f3))

    //方法和函数的区别及转换：https://blog.csdn.net/u010839779/article/details/80849607
    /**
      * 1、方法可以作为表达式的一部分出现，无参的方法可以直接作为最终表达式，函数也可以作为最终表达式出现；但有参方法不行
      * 2、参数列表对于方法是可选，但是函数必须要有
      * 3、方法名意味着函数的调用，但函数只能代表函数本身
      * 4、方法可以手动或者自动(ETA扩展)转换成函数，但是函数不可以转换成方法
      */
  }
}
