package day05

import scala.actors.Actor

/**
  * 偏函数中的匹配使用case类
  * !
  *
  * 接收消息用：recevie 或 react
  * 返回消息用：sender
  *
  * !! :
  */

//封装异步消息对象
case class AsyncMsg(uid:String,uname:String)

//封装同步消息对象
case class SyncMsg(uid:String,uname:String)

//封装可能的返回值
case class ReplyMsg(tag:String,info:String)

//封装退出对象,样例类中主构造器没有任何参数时，则直接使用case object
case object Stop

//自定义线程
class ActorCaseDemo extends Actor{
  override def act(): Unit = {
    loop(react{
      //接收异步消息 !!
      case AsyncMsg(uid,uname) =>{
        println(s"AsyncMsg=====uid:$uid,uname:$uname")
        //可以根据线程发送过来的消息进行逻辑实现
        //逻辑实现完成后，必须要返回结果给"主线程",但是主线程不会等待actor的返回值
        sender ! ReplyMsg("AsyncMsg","异步消息的返回值")
      }

      //接收同步消息 !?
      case SyncMsg(uid,uname) =>{
        println(s"SyncMsg----------uid:$uid,uname:$uname")
        //可以根据线程发送过来的消息进行逻辑实现
        //逻辑实现完成后，必须要返回结果给"主线程",但是主线程会等待actor的返回值
        Thread.sleep(10000) //睡眠
        sender ! ReplyMsg("SyncMsg","同步消息的返回值")
      }
      case "started" => {println("线程开启...")}
      case Stop => {
        println("线程停止...")
        exit() //退出线程
      }
    })
  }
}

//测试
object ActorCaseDemo{
  def main(args: Array[String]): Unit = {
    val actorCaseDemo = new ActorCaseDemo
    actorCaseDemo.start() //启动线程

    //1、模拟发送异步消息，没有返回值 !
    actorCaseDemo ! "started"
    //2、模拟发送同步消息，有返回值，并且等待返回值
    println("发送同步消息，并且等待返回值...")
    val res:Any = actorCaseDemo !? SyncMsg("007","二狗")
    //
    if (res.getClass == classOf[ReplyMsg]){
      val re = res.asInstanceOf[ReplyMsg]
      println(s"打印线程获取的返回值,tag:${re.tag},info:${re.info}")
    }
    println("接收到同步消息的返回值....可以继续往下执行...")

    //3、模拟发送异步消息，有返回值，但不等待 !!
    println("发送异步消息 !!....")
    val ares = actorCaseDemo !! AsyncMsg("110","二愣子")
    //循环  业务
    for(i <- 1 to 10){
      println("i=======:"+i)
      Thread.sleep(500)
    }
    //如果咱们下面的业务需要依赖线程的返回值
    if(!ares.isSet){  //等于true，已返回
      Thread.sleep(5000)
      println("等待异步结果值返回...")
    }
    //最终获取异步消息返回值
    val replyMsg = ares.apply() //不加apply取不到返回值
    if(replyMsg.getClass == classOf[ReplyMsg]){
      val r = replyMsg.asInstanceOf[ReplyMsg]
      println(s"打印异步返回结果值,tag:${r.tag},info:${r.info}")
    }
    //关闭
    actorCaseDemo ! Stop  //关闭
  }
}