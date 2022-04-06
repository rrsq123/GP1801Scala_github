package day02

/**
  * scala中的分：主构造器和辅助构造器，主构造器是紧跟在类名后面，辅助构造器在类中，二者都可以选择定义
  */
class ConstructorDemo(private[this] val sno:Int,var sname:String) {
  //
  var score:Double = 99.0
  var sex:String = "2"
  var sclass:String = "gp1801"

  //辅助构造器
  def this(sno:Int,sname:String,sclass:String,ssex:String = "1") ={
    this(sno,sname)
    this.sex = ssex
  }

  /*//定义辅助构造器 名称为this，辅助构造器中需要先调用主构造器
  def this(sno:Int,sname:String,sclass:String) ={
    this(sno,sname)
    this.sclass = sclass
  }
  //辅助构造器
  def this(sno:Int,sname:String,sclass:String,score:Double) ={
    this(sno,sname,sclass)
    this.score = score
  }*/



  /**
    * 构造器中的final修饰无效？？？
    * @return
    */
  override def toString: String = {
    s"sno:${sno},sname:${sname},sclass:${sclass},score:${score},sex:${sex}"
  }
}


/*object ConstructorDemo{
  def main(args: Array[String]): Unit = {
    val con = new ConstructorDemo(110,"公安")
    val con1 = new ConstructorDemo(114,"查询","gp1801")
//    val con2 = new ConstructorDemo(119,"火警","gp1801",66.66)

    println(con)
    println(con1)
//    println(con2)
  }
}*/

object ConstructDemoTest{
  def main(args: Array[String]): Unit = {
    val con = new ConstructorDemo(110,"aa")
    println(con)
  }
}

/**
  * 辅助构造器中的第一行必须是this() 主构造器
  *
  * 抽象类
  * 特质
  * 模式匹配
  * 枚举
  * 偏函数
  * 高阶函数
  * 类的转换
  *
  * actor：
  * akka：
  * mutable：
  * immutable:
  */