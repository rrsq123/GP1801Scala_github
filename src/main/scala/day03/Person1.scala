package day03

/**
  * scala中的类的继承：
  * 子类继承父类，与java一样使用关键字extends
  * 继承代表子类可以共享父类的属性和方法
  * 子类可以在内部定义父类没有，子类可以拥有自己的属性和方法，也可以重写父类的属性和方法
  */
class Person1 {
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
class QFStudent1 extends Person1 {
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

//定义一个QFTeacher extends Person1
class QFTeacher extends Person1 {
  //子类特有的属性
  var teano:Int = _
  var teadept:String = _

  //父类中的私有属性不能继承
  //如果需要覆盖普通父类的val/var修饰的属性，必须要加override，并且当前这个也是val
  override val sex: String = "男"

  //辅助构造器
  def this(teano:Int,sname:String,teadept:String){
    this()
    this.teano = teano
    this.name = sname  //覆盖父类中属性
    this.teadept = teadept
  }

  //辅助构造器
  def this(sname:String,ssex:String,teano:Int){
    this()
    this.teano = teano
    this.name = sname  //覆盖父类中属性
    val this.sex = ssex //覆盖父类中val修饰的属性时，需要在当前属性前也加val,不能修改继承的val的属性
  }

  //继承父类的方法，继承普通方法也需要使用overwride
  override def work(job:String): Unit = {
    println(s"$job is student work.")
  }

  //定义自己的方法
  def getInfo(): Unit = {
    println(s"teano:$teano,sex:$sex,sclass:$teadept,age:$age")
  }
}

//判断类所属的测试：即判断对象是否属于某一个类isInstanceOf
object Person1{

    def getStuInfo(stu:QFStudent1)={
      stu.getInfo()
    }

    def getTeaInfo(tea:QFTeacher)={
     tea.getInfo()
    }

    //判断 isInstanceOf 判断对象是否属于类和父类，该方法不能精确到指定的类
    //asInstanceOf 转换对象为指定的类，如果转换成子类的对象出错
    def isInstance(per:Person1)={
      if(per.isInstanceOf[QFStudent1]){ //对象.isinstanceOf[类]
          val stu = per.asInstanceOf[QFStudent1] //转换成对应的类的对象 .asInstanceOf[类]
          stu.getInfo()
      } else if(per.isInstanceOf[QFTeacher]){ //对象.isinstanceOf[类]
        val tea = per.asInstanceOf[QFTeacher] //转换成对应的类的对象 .asInstanceOf[类]
        tea.getInfo()
      }
    }

    //判断2
  /**
    *
    * 精准判断： classOf[] 方式精确判断是否属于指定一个类，子类父类都不可以
    */
    def isInstance_class(per:Person1)={
      if(per.getClass == classOf[QFStudent1]){ //对象.isinstanceOf[类]
        val stu = per.asInstanceOf[QFStudent1] //转换成对应的类的对象 .asInstanceOf[类]
        stu.getInfo()
      } else if(per.getClass == classOf[QFTeacher]){ //对象.isinstanceOf[类]
        val tea = per.asInstanceOf[QFTeacher] //转换成对应的类的对象 .asInstanceOf[类]
        tea.getInfo()
      }
    }
}

/**
  * 测试
  */
object Person1Test{
  def main(args: Array[String]): Unit = {
    val stu = new QFStudent1(110,"zs","gp1801")
    val tea = new QFTeacher(111,"ww","bigdata")
    //近似判断
    Person1.isInstance(stu)
    Person1.isInstance(tea)

    //精确判断
    Person1.isInstance_class(stu)
    Person1.isInstance_class(tea)
  }

  /**
    * obj.isInstanceOf[A] ：obj对象是否属于指定的A类及其子类，不能准确指定obj到底属于哪个类
    * a= obj.asInstanceOf[A] ：将obj转化成A类的对象
    * obj.getClass = classOf[A] : 获取A类的类，通常和obj.getClass来判断，能准确确定obj是否属于A类
    */
}