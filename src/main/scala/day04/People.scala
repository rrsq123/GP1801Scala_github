package day04

class People {
  implicit val name:String = "aa"
  def work()={
    println("aaaaa")
  }
}

class Stu extends People {
  implicit def work1()={
    println("sssssss")
  }
}

class Child extends People{
  def work2()={
    println("sssssss")
  }
}

//隐式区域
object ImplictDemo011{
  //定义隐式函数
  implicit def any2People(obj:Any):People ={
    if(obj.getClass == classOf[Student]){
     new People()
    }else if(obj.getClass == classOf[Child]){
      new Child()
    } else if(obj.getClass == classOf[Stu]){
      new Stu()
    } else {
      new People()
    }
  }
}

object PeopleDemo{
  def main(args: Array[String]): Unit = {

    import ImplictDemo011._
    val stu = new Stu
  }
}
