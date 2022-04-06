package day04

/**
  * scala中的隐式参数：使用implict修饰的参数
  *调用带有隐式参数的方法时，不传入参数，默认使用引入的隐式区域的相同类型的隐式参数
  * 隐式区域：
  */
object ImplictArgs {
  //定义一个隐式参数
  implicit val age:Int = 16
  //在同一个隐式区域不能定义相同类型的隐式参数，否则会出现歧义
  implicit val sex:Int = 1

  implicit var name:String = "小花"
}
//在不同的区域可以定义相同类型的隐式参数
object ImplictArgs1 {
  //定义一个隐式参数
  implicit val age:Int = 18
}

//隐式参数测试
object ImplictArgsTest{
  //带普通参数方法
  def getName(name:String) = {
    println(s"name is $name")
  }
  //带隐式参数的方法
  def getAge(implicit age:Int): Unit ={
    println(s"age is $age")
  }

  //带隐式参数的方法
  def getName1(implicit name:String): Unit ={
    println(s"implict name is $name")
  }

  def main(args: Array[String]): Unit = {
    //调用带普通参数的方法
    getName("老王")
    //调用带隐式参数的方法
    getAge(20)

    //不传参数调用带隐式参数的方法
    //如果调用带有隐式参数的方法不传参数时，需要引入隐式区域,方法会自动调用隐式区域相同类型的值
    import ImplictArgs.age
//    import ImplictArgs.sex
    getAge
//    getName1
  }
}
