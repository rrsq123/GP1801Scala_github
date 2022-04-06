package day05

import scala.actors.Actor

/**
  * scala的actor类似于java的多线程，来实现并发编程。
  * scala默认在2.10.x及以前的版本使用actor，。2.11.x之后使用Akka来编程
  * scala的actor也是通过start()启动actor，然后运行act()方法，然后进行消息发送。
  *
  * scala中自己定义的actor需要继承Actor
  */
class MyActor extends Actor{
  //类似于java中的run()方法
  override def act(): Unit = {
    //线程的逻辑
    for(i <- 1 to 10){
      println("i==========="+i)
      Thread.sleep(1000) //睡眠1秒
    }
  }
}

//测试actor
object MyActorTest{
  def main(args: Array[String]): Unit = {
    //获取线程实例
    val myActor = new MyActor
    //开启线程
//    myActor.start() //异步
    myActor.act() //调用子线程的act()方法，然后会线程阻塞，必须子线程执行完之后才执行下面
    println(myActor.getState.toString) //获取线程状态
    for (j <- 1 to 200){
      println("j==========="+j)
      Thread.sleep(1000) //睡眠1秒
    }
  }
}
