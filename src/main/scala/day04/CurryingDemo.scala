package day04

/**
  * 柯里化：指将原来接受两个参数的函数变成接受一个参数函数的过程，
  * 返回的新的函数可以接收后面的参数。
  */
object CurryingDemo {
  def main(args: Array[String]): Unit = {
    //非柯里化的方法
    def noCurrying(x:Int,y:Int) = x * y
    //定义一个柯里化的方法
    def currying(x:Int)(y:Int) = x * y

    //定义非柯里化的函数
    val noCurrying1 = (x:Int,y:Int) => x + y
    //定义一个柯里化的函数
    val currying1 = (x:Int) =>(y:Int) => x + y

   //测试
    println(noCurrying1(10,20))
    println(currying1(10)(20))

    /**
      * 柯里化的过程
      */
    val currying2 = (x:Int) =>(y:Int) => x + y
    val res = currying2(10)//执行后返回的是一个新函数
    val res1 = res(20)//然后给这个新函数传递参数20
    println(res,res1)//输出结果：（<function1>,30）

    //柯里化的变量
    val v1 = currying2(10)
    println(v1)
    println(v1(6))
  }
}
