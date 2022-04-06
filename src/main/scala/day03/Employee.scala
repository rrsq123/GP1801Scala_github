package day03

/**
  * 抽象类：使用abstract来修饰
  * 1、一个类中如果有一个抽象方法或属性，那该类需要使用abstract来修饰，抽象类不能被实例化
  * 2、在子类中覆盖抽象方法时，可以不需要使用overwride关键字
  * 3、抽象方法：抽象类中方法不给出具体的实现，只有方法名和参数，则是抽象方法
  * 4、抽象属性：在抽象类中，定义咯属性，不给具体初始值，则就是抽象属性
  * 不能实现抽象类，scala中没有impliments关键字
  * 子类继承抽象类，子类必须要覆盖其抽象属性和方法，并可以定义自己属性和方法。
  */
abstract class Employee {
  //定义普通属性
  var age:Int = _
  var salay:Double = 98.0

  //定义抽象属性
  var name:String
  var marry:Boolean

  //定义普通方法
  def employeeInfo(): Unit ={

  }

  //定义抽象方法
  def work(job:String):String
}

//定义一个前锋的员工类继承抽象类，主构造器中的字段不能使用抽象类中的字段，子类中也不能覆盖抽象类中普通属性
class QFEmployee(eno:Int,ename:String,esalay:Double) extends Employee{

  override var name: String = ename
  override var marry: Boolean = false

  //给父类中普通属性赋值，
  // 如果需要覆盖父类中的普通属性属性和方法，必须要overwride关键字
  //如果需要覆盖父类中抽象属性和方法，可以添加overwride，也可以不添加，但推荐添加
  age = 30
  salay = esalay

  override def employeeInfo(): Unit = {
    println(s"eno:$eno,ename:$ename,esalay:$esalay,age:$age")
  }

  override def work(job: String): String = {
    s"$job is teacher work."
  }
}

/**
  * 测试
  */
object Employee{
  def main(args: Array[String]): Unit = {
    val qFEmployee = new QFEmployee(110,"zs",3.0)
    println(qFEmployee.work("teaching "))
    qFEmployee.employeeInfo()
  }

  /**
    * 子类继承抽象类时，抽象方法和属性可以不用overwride，但是必须要实现
    * 子类继承抽象类时，普通方法和属性必须overwride
    * 子类中主构造器和类中不能定义抽象类中的普通属性(名称相同)
    */
}
