package day03

/**
  * 学生类
  * 直接使用object的名称去初始化对象。
  * 在object对象中编写apply()方法
  *
  * Student(1,2,3,4,5)
  * new Student(1,2,3)
  */
class Student {
  var sno:Int = _
  //在属性后可以使用_来赋予对应类型的默认值
  var sname:String = _
  var ssex:String = _

  //辅助构造器
  def this(sno:Int,sname:String){
    this()
    this.sno = sno
    this.sname = sname
  }

  //辅助构造器
  def this(sno:Int,sname:String,ssex:String){
    this(sno,sname)
    this.ssex = ssex
  }

  override def toString: String = {
    s"sno:$sno,sname:$sname,sex:$ssex"
  }
}

//伴生对象中定义apply()方法，apply()方法本质是new 对象
object Student {
  //定义一个无参的apply方法
  def apply(): Student = new Student
//  def apply: Student = new Student()

  //定义一个带参数的apply方法
  def apply(sno:Int): Student = {
    val stu = new Student()
    stu.sno = sno
    stu
  }

  //定义2个带参数的apply方法
  def apply(sno:Int,sname:String): Student = {
    val stu = new Student()
    stu.sno = sno
    stu.sname = sname
    stu
  }

  //定义2个带参数的apply方法
  def apply(sno:Int,sname:String,sex:String): Student = {
    val stu:Student = apply(sno,sname)
    stu.ssex = sex
    stu
  }
}

/**
  * ce
  */
object StudentTest{
  def main(args: Array[String]): Unit = {
    val arr1 = Array(1,2,3,4,5,6)

    //使用常规new方式
    val stu01 = new Student
    val stu02 = new Student(110,"aa")
    val stu03 = new Student(119,"cc","1")
    println(stu01,stu02,stu03)
    //使用object对象方式获取对象
    val stu = Student()
    val stu1 = Student(112,"okay")
    val stu2 = Student(119,"xiaohuo","1")
    println(stu,stu1,stu2)
  }
}
