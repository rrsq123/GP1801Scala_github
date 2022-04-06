package day02

class Person {
  val name:String = "老王"
  var IDCard:String = "99999110"
  //private var/val 修饰的变量都只能是该类的伴生对象或者该类使用
  private val age:Int = 30

//  private var sex:Char = '男'
//  private[day02] var sex:Char = '男' //在当前的包和该类的伴生对象中使用
  private[this] var sex:Char = '男' //只能在该类和其子类中使用，伴生对象也不能访问

  protected val year:Int = 2018 //代表可以被该类、子类、伴生对象中可以使用
  protected[day02] val month = 11 //代表可以被该类、子类、、该类所在的包、伴生对象中可以使用
}

class employ{

}

class staff{

}

/**
  * object 后的名称和class后的名称一模一样，那就称object后的对象为其class的伴生对象，class后的类为其object的伴生类
  * 如：
  * class A{}
  * object A{}
  * object A是class A的伴生对象，而Class A就是object的伴生类
  */
object Person{
  def main(args: Array[String]): Unit = {
    val person = new Person  //获取person的对象
    println(person.age)
//    println(person.sex)  private[this] 修饰的伴生对象不能获取
    println(person.year)
    println(person.month)
  }
}

object Person01{
  def main(args: Array[String]): Unit = {
    val person = new Person  //获取person的对象
//    println(person.age)
  }
}
