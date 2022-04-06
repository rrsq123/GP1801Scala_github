package day04

/**
  * scala中的泛型
  * 定义方法、类可以使用泛型
  * 泛型类：
  * calss A[T]
  * 泛型方法：
  * def f1[T](t:T) = {}
  */

class TStudent{
  def getStuInfo() = "every one of us"
}

class TTeacher{
  def getTeaInfo() = "every one of you"
}

//测试
object TDemo{
  def showStuInfo(stu:TStudent)={
    println(s"we are shehui student."+stu.getStuInfo())
  }
  def showTeaInfo(tea:TTeacher)={
    println(s"we are shehui teacher."+tea.getTeaInfo())
  }

  //定义泛型方法
  def showInfo[T](t:T)={
    if(t.getClass == classOf[TStudent]){
      val stu = t.asInstanceOf[TStudent]
      showStuInfo(stu)
      } else if(t.getClass == classOf[TTeacher]){
      val tea = t.asInstanceOf[TTeacher]
      showTeaInfo(tea)
    }
  }

  def main(args: Array[String]): Unit = {
    //测试
    val stu = new TStudent
    val tea = new TTeacher

    showInfo(tea)
    showInfo(stu)
  }
}