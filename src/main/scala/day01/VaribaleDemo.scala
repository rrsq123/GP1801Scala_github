package day01

/**
  * scala的变量
  * var : 申明可以变，可以修改，编译后set()和get()方法，类似java的public
  * val :申明变量不可以变，指地址不可变，即值也不可变，编译后只有getter(),没有setter(),相当于java中final修饰
  * lazy :惰性申明，只有在调用该变量的时候才被实例化，该修饰只能跟val搭配使用，即lazy val
  * def :申明的变量不可变，类似val
  */
object VaribaleDemo {
  def main(args: Array[String]): Unit = {
    //定义变量
    var a:Int = 1
    var aa = 2
    val aaa:Int = 3
    lazy val aaaa = 4
    def aaaaa = 5
    val _1=23

    println(aa.getClass)
    println(aa)
    println(a,aa,aaa,aaaa,aaaaa)
    println(_1)

    /**
      * 变量名称：
      * 1、不能以数字开始
      * 2、不能使用特殊符号来开始，如*。有些特殊符号有专门的用途 _、____
      * 3、不能使用scala中的关键
      */

    //值可变和不可变的测试
    a = 11
//    aaa = 33
//    aaaa = 44
//    aaaaa = 55
    println(a)


    //scala中的变量的类型是可以不用指定，scala会在运行时自动推断
    val str = "double 666"
    val dou = 66.66
    val flo = 999.99f
    println(str.getClass)
    println(dou.getClass)
    println(flo.getClass)

    /**
      * scala中的类型
      * scala中有9中类型，7中值类型，2种非值类型
      * 7个值类型：Double,Float,Long,Int,Char,Short,Byte
      * 2个非值类型：Unit、Boolean
      * scala中有一个顶级基类Any，相当于java中的object
      * Any下有两个子类，分别是AnyVal属于值类型父类，AnyRef属于引用类型
      * Null ： 是引用类型的子类
      * Nothing：是所有类型的子类
      * scala中的类型都大写字母开始
      */
    val c:Char = '9'
    val saley:Double = 50000.00
    val age:Float = 20.0f
    val wedding:Boolean = false
    val li = null
//    val li1:AnyRef = Null
    println(c)
    println(saley,age,wedding,li)

    //值类型转换，只能低转高
    //1、byte-->Short--->Int--->Long--->Float--->Double
    //2、char--->Int--->Long--->Float--->Double
    val x:Long = 10
    val y:Double = x
//    val z:Int = y 不能转换
//    val z:Int = (Int)y  不可以强制转换
    println(y)

    //scala中的操作(类似java中的> < ! * - + )
    //scala中是没有操作符概念，其实使用操作符就是调用方法。
    //常见操作：
    /**
      * 数学：+ - * / %
      * 关系：> < <= >= !
      * 位运算：
      * 比较：== !=
      * scala中不支持++ 和 -- ,但是可以使用+= 和 -=来实现
      */
    var n = 8
    var m = 2
    println(n+m +":"+ n.+(m))  //两者等价
//    println(m++)
//    println(n--)
    m+=1
    println(m)
  }
}
