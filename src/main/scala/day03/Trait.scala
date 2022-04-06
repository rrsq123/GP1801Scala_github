package day03

/**
  * scala中的特质：类似于java中的接口
  * 1、scala中的trait是一种特殊概念
  * 2、首先trait可以当作接口使用，此时trait和java中的接口很类似
  * 3、在trait中可以定义抽象方法，与抽象类中的抽象方法一样，只给出方法签名，不给具体事项，抽象属性也和抽象类中一样
  * 4、类可以使用extends来继承，trait同样可以使用extends来继承。无论继承抽象类、普通类、trait都用extends来继承
  * 5、类继承trait之后，必须实现其中的抽象方法，实现可以不需要使用关键字overwride
  * 6、scala中支持多继承，多继承使用with，使用extends开始
  * 7、特质需要使用关键字trait来修饰
  */
trait Fly {
  //抽象属性
  var flyTime:Int
  //普通属性
  val flyNums:Int = 2
  //抽象方法
  def flyWith(what:String)
  //普通方法
  def moveWith(tp:String): Unit ={
  }
}
//声音类型的特质
trait VoiceType{
  def voiceType(voice:String)
}
//抽象类
abstract class Animal{
  //抽象属性
  var tp:String
  var like:String
  //抽象方法
  def eatWhat(what:String)
  //普通方法
  def doWhat(what:String) = {
  }
}
//测试继承抽象类和特质
class AnimalTest(typ:String,flytime:Int) extends Animal with Fly with VoiceType {
  override var flyTime: Int = flytime
  override var tp: String = typ
  override var like: String = _

  //辅助构造器
  def this(typ:String,flytime:Int,lk:String){
    this(typ,flytime)
    this.like = lk
  }

  override def flyWith(what: String): Unit = {
    println(s"use $what fly...")
  }
  override def voiceType(voice: String): Unit = {
    println(s"voice is $voice")
  }

  override def eatWhat(what: String): Unit = {
    println(s"eat is $what")
  }
}
//只有特质:也可以直接继承
class An extends VoiceType with Fly {
  override def voiceType(voice: String): Unit = ???

  override var flyTime: Int = _

  override def flyWith(what: String): Unit = ???
}

object TraitDemo{
  def main(args: Array[String]): Unit = {
    val bird = new AnimalTest("foot",1000)
    bird.like = "飞"
    println(bird.like)
    bird.eatWhat("毛毛虫")
    bird.flyWith("脚")
    bird.voiceType("叽叽喳喳")

    val person = new AnimalTest("foot",1)
    person.like = "sleep"
    println(person.like)
    person.eatWhat("鲍鱼")
    person.flyWith("灰机")
    person.voiceType("叽歪叽歪")
  }

  /**
    * 特质：
    * 可以被多继承，当特质和抽象同时存在，必须先extends抽象类
    * 特质可当成接口、也可以当成抽象类使用。
    * 特质和抽象类一样，不能被直接实例化。
    */
}


