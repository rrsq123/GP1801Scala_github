package day03

import scala.util.Random

/**
  * scala中的模式匹配，类似于java中的switch case
  * 格式：
  * 值/表达式 match{
  * case "值1" => {语句}
  * case "值2" => {语句}
  * }
  */
object MatchCaseDemo {
  def main(args: Array[String]): Unit = {
    //默认匹配是内容匹配
    def content_matchcase(idx:Int): Unit ={
      var arr:Array[String] = Array("hadoop","spark","flink","storm","sklearn")
      //从arr获取随机值
      val content = arr(idx)
      //匹配
      content match {
        case "hadoop" => println(s"随机获取的元素为：hadoop")
        case "spark" => println(s"随机获取的元素为：$content")
        case "flink" => println(s"随机获取的元素为：$content")
        case _ => println(s"上面都没有匹配上,元素为:$content")
      }
    }

    //基于类型匹配：
    def type_matchcase(a:Any): Unit ={
      //进行类型匹配
      a match {
        case x:String => println(s"匹配到String类型:$x")
        case x:Int => println(s"匹配到Int类型，值为$x")
        case x:Boolean => {
          println(s"匹配到的类型为Boolen，值为$x")
        }
        case _ => println(s"上面都匹配不上，$a")
      }
    }

    //数组匹配
    def arr_matchcase(): Unit ={
      var arr:Array[Int] = Array(1,2,3)

      //匹配
      arr match {
//        case Array(1,2,_) => println(s"匹配第一个元素为1，第二元素为2，第三个任意")
//        case Array(1,2,3) => println(s"匹配第一个元素为1，第二元素为2，第三个3")
        case Array(x,y,3) => println(s"匹配第一个元素为$x，第二元素为$y，第三个3")
        case Array(1,_,_) => println(s"匹配第一个元素为1")
        case _ => println(s"上面都没有匹配上")
      }
    }

    //元组
    def tup_matchcase(): Unit = {
      var tup: (String, Int, Double) = Tuple3("spark", 1000, 30000.0)

      //匹配
      tup match {
        //        case ("",1000,30000.0) => println(s"匹配的元素 1000,30000.0")
        //        case (_,1000,30000.0) => println(s"匹配的元素 1000,30000.0")
        //        case (x,1000,30000.0) => println(s"222$x,1000,30000.0")
        //        case (y,1000,x) => println(s"$y,1000,$x")
        //        case ("spark",1000) => println(s"匹配需要和match前的值的类型一样") //类型不对
        case _ => println(s"上面都没有匹配上")
      }
    }
    //匹配list
    def list_matchcase(): Unit ={
      var li:List[Int] = List(20,-30,50)

      //Nil 是空，empty()
      //匹配
      li match {
        case 20::30::Nil => println(s"20::30::Nil")
//        case x::y::50::Nil => println(s"$x::$y::50")
//        case head::(-30)::50::Nil => println(s"::-30::50")
//        case head::(-30)::tail => println(s"head::(-30)::tail")
//        case head:+ -30 :+ 50 => println(s"head:+ -30 :+ 50")
        case head :: (-30) :: _ ::Nil => println(s"head :: (-30) :: _ ::Nil ")
        case _ => println(s"上面都没有匹配不上")
      }
    }


    /**
      * scala的Option的操作
      * option:它可以代表一个可能的值，但也可能是一个空，如果这返回某个值的类型为option可以避免空指针
      * Option[T] : T就是一个可能的具体的值泛型，如果存在则是Some(),如果不存在则是None
      * @param x
      * @return
      */
    //将string转换成int类型，如果出现异常则返回0
    def toInt(x:String): Option[Int] ={
      try{
        Some(Integer.parseInt(x.trim))
      } catch {
        case e:Exception => None
      }
    }

    def option_case(aa:Option[Int]): Int ={
      aa match {
        case Some(v) => v
        case None => 0
      }
    }

    //测试
//    content_matchcase(3)
//    type_matchcase(true)
//    arr_matchcase()
//    tup_matchcase()
//    list_matchcase()
//    println(toInt("1").getOrElse(0))
    println(option_case(toInt("1")))

    /**
      * 值 match{
      * case 值1 =>
      * case _ => 上面匹配不了就走他
      * }
      */


    /**
      * 样例类
      * 隐式转换
      * 偏函数
      * 柯里化
      * 上下边界
      * 高阶函数：
      * actor
      */
  }
}
