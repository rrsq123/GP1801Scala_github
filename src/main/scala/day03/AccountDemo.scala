package day03

/**
  * 1、伴生类和伴生对象：类名和object名称相同，且均在一个.scala文件中，他们之间可以相互访问私有属性
  */
class AccountDemo(age:Int) {
  val name:String = "老大"
  private var sex:String = "1"

  def getInfo(): Unit ={
    println(s"name:$name,sex:$sex")
  }
}
//伴生类
object AccountDemo{
  val na:String = "伴生对象"
  def getInfo1(): Unit ={
    val accountDemo = new AccountDemo(20)
    println(accountDemo.name)
    println(accountDemo.getInfo())
    //调用伴生类中的方法
    accountDemo.getInfo()
  }
}
//非伴生对象
object AcountDemoTest{
  def main(args: Array[String]): Unit = {
    //object中的属性和方法相当于static，可以使用object后的名称.属性/方法
    //scala中没有静态，但是object就相当于静态
    //object可以当成工具类、或者常量类来使用
    //object本身就是单利对象，在第一次调用object的时候，将会执行该对象中的非方法和块代码。
    println(AccountDemo.na)  //静态调用属性
    AccountDemo.getInfo1()  //静态调用方法，

    //判断是否为单利
    val accountDemo1 = AccountDemo
    val accountDemo2 = AccountDemo
    println(accountDemo1.hashCode())
    println(accountDemo2.hashCode())
  }
}