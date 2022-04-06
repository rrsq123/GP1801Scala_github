package day05

import scala.actors.Actor

/**
  * scala中使用message来发送接收线程消息
  * 接收消息使用recevie关键字,while(true) {recevie({偏函数})} 等价 loop(react({偏函数}))
  *
  */
class MyRecevieActor extends Actor{
  override def act(): Unit = {
    /*while (true){
      receive({
        case "started" => {
          println("actor 线程已经启动...")
        }
        case "recevice" => {
          println("the actor recevie message...")
        }
        case "stoped" =>{
          println("the actor stoped....")
          exit()  //退出
        }
      });
    }*/
    loop(
      react({
        case "started" => {
          println("actor 线程已经启动...")
        }
        case "recevice" => {
          println("the actor recevie message...")
        }
        case "stoped" =>{
          println("the actor stoped....")
          exit()  //退出
        }
      })
    )
  }
}
//测试
/**
  * ! : 发送异步消息，没有返回值
  * !?: 发送同步消息，有返回值，并等待返回值
  * !!: 发送异步消息，有返回值，Fature[Any],不需要等待返回值
  */
object MyRecevieActorTest{
  def main(args: Array[String]): Unit = {
    //初始化线程
    val myRecevieActor = new MyRecevieActor
    myRecevieActor.start() ! "started"

    //循环发送消息
    for (i <- 1 to 5){
      println("i======"+i)
      myRecevieActor ! "recevice"
      Thread.sleep(1000)
    }

    //退出线程
    myRecevieActor ! "stoped"
  }
}
