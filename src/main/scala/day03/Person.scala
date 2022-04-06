package day03

/**
  * scala中的类的继承：
  * 子类继承父类，与java一样使用关键字extends
  * 继承代表子类可以共享父类的属性和方法
  * 子类可以在内部定义父类没有，子类可以拥有自己的属性和方法，也可以重写父类的属性和方法
  */
class Person {
  var name:String = _
  val age:Int = 0
  val sex:String = "男"

  private val life:Boolean = true
  private[this] var marry:Boolean = false

  def work(job:String): Unit ={
    //do nothing  子类重写
  }
}

//千锋学生继承人类
class QFStudent extends Person{
  //子类特有的属性
  var sno:Int = _
  var sclassName:String = _

  //父类中的私有属性不能继承
  //如果需要覆盖普通父类的val/var修饰的属性，必须要加override，并且当前这个也是val
  override val sex: String = "女"

  //辅助构造器
  def this(sno:Int,sname:String,sclass:String){
    this()
    this.sno = sno
    this.name = sname  //覆盖父类中属性
    this.sclassName = sclass
  }

  //辅助构造器
  def this(sname:String,ssex:String,sno:Int){
    this()
    this.sno = sno
    this.name = sname  //覆盖父类中属性
    val this.sex = ssex //覆盖父类中val修饰的属性时，需要在当前属性前也加val,不能修改继承的val的属性
  }

  //继承父类的方法，继承普通方法也需要使用overwride
  override def work(job:String): Unit = {
    println(s"$job is student work.")
  }

  //定义自己的方法
  def getInfo(): Unit = {
    println(s"sno:$sno,sex:$sex,sclass:$sclassName,age:$age")
  }
}

//定义一个QFTeacher extends Person

object Person{
  def main(args: Array[String]): Unit = {
    val stu = new QFStudent(110,"zs","gp1801")
    val stu1 = new QFStudent("ww","男",119)

    stu.getInfo() //调用自己的方法
    stu1.getInfo()
    stu.work("coding")
  }
}
