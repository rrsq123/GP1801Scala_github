package day01

/**
  * scala中的条件表达式
  * 1、表达式和语句的区别？
  * 2、条件表达式不适合return语句，因为条件表达式放在语句最后就是一个返回值
  * 3、if else后跟值，则可以直接返回
  */
object ConditionDemo {
  def main(args: Array[String]): Unit = {
    val age:Int = 18
    val res:String = if(age >= 18) "可以直接进入..." else "未成年."
    println(res)

    //if和else中的是混合类型，返回的结果不能指定类型
    val sex:String = "男"
    val res1 = if(sex == "女") "加起" else 2
    println(res1)

    //只有if，丢失else的情况，那scala会默认给Unit的返回()
    val name:String = "luo1"
    val n1 = if(name == "luo") "老罗"
    println(n1)

    //如果if和else的语句中的最后一个句作为返回值
    val res2:String = if(sex == "男"){
      var gender:String = "man"
      gender
    } else if(sex == "女"){
      var gender:String = "women"
      gender
    } else "人妖"

    //ifelse的语句中最后一句不能是赋值语句，因为赋值语句不知道返回啥
    println(res2)
    var gender:String = ""
    val res3 = if(sex == "男"){
//      gender = "man"
    } else if(sex == "女"){
      var gender:String = "women"
      gender
    } else "人妖"
  }

  /**
    * 除咯能返回值，其它和java一样
    * scala中的条件比较简洁
    * scala中的条件表达式可以返回值
    * scala中没有switch()语句，只能使用if来实现
    */
}
