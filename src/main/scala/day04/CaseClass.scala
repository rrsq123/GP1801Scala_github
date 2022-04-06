package day04

import scala.util.Random

/**
  * 样例类：
  * 需要使用case 来修饰，可以用于模式匹配。case class是多例，case object是单例。
  * case class通常类似java的bean，用于封装信息，一般不写逻辑
  * scala会自动为case class定义伴生对象，并且伴生对象中默认实现apply()方法，
  * 该apply()方法接收和主构造器参列表相同。同时返回对应case calss对象。
  */

//样例类
case class SubmitTask(id:Int,taskName:String)

case class HeartBeat(timeStamp:Long)
//样例对象
case object CheckTimeOut

//测试
object CaseClass{
  def main(args: Array[String]): Unit = {
    val arr = Array(
      SubmitTask(1000001,"job_application_1000001"),
      HeartBeat(3000l),
      CheckTimeOut
    )

    //模式匹配样例类
    arr(0) match {
     /* case SubmitTask(id,taskName) =>{
        println(s"提交的任务为$id,名称为$taskName")
      }*/
      case HeartBeat(times) =>println(s"心跳时间:$times")
      case CheckTimeOut => println("检测超时")
      case _ => println("默认匹配")
    }
  }
}