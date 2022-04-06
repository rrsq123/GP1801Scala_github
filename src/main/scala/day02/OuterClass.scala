package day02

/**
  * 外部内
  */
class OuterClass {
  //普通属性
  val name:String = "小黑"
  //普通方法
  def work():String = {
    "product house..."
  }
  //定义一个内部类
  class InnerClass{
    var nname:String = "" //内不类的属性必须初始化
    def getInfo = {
      nname = name + "黑"
      s"name:${nname},age:0.5"
    }
  }

  //在外部类中定义一个方法来获取内部类的对象，过度
  def getInner():InnerClass = {
    val innerClass = new InnerClass
    innerClass.nname = "老黑"
    innerClass
  }
}

object OuterClass{
  def main(args: Array[String]): Unit = {
    val outerClass = new OuterClass
    val outerClass1 = new OuterClass()
    val innnerclass = outerClass.getInner()  //通过外部类的对象获取内部类的对象

    println(outerClass.name)
    println(outerClass.work())

    //获取内部的属性
    println(innnerclass.nname)
    println(innnerclass.getInfo)
  }
}
