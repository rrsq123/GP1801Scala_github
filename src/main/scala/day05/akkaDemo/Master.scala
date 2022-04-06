package day05.akkaDemo

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}


/**
  * akka的actor也需要继承Actor。 包:akka.actor
  */
class Master extends Actor{
  //可以选择重写，在recive方法执行之前仅执行一次
  override def preStart(): Unit = {
    println("prestart function start...")
  }
  //该方法用于接收信息，该方法在Actor中是一个抽象方法，必须要实现，需要返回一个偏函数
  //同样需要偏函数接收信息
  override def receive: Receive = {
    //偏函数
    case "start" => println("接收到线程发送的消息...")
    case "connect" => {
      println("connecting...")
      sender() ! "reply"
    }
    case "stop" => {
      println("stoped...")
      context.stop(self)  //退出
    }
  }
}

//测试
object Master{
  def main(args: Array[String]): Unit = {
    //配置主机和ip信息
    val host = "localhost"
    val port = 6666

    val config_str =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
         """.stripMargin //该定义使用|来去分割

    //将配置信息构建成config对象
    val config:Config = ConfigFactory.parseString(config_str)

    //创建Akka的actor对象
    val actorSystem = ActorSystem("MasterSystem",config)
    val master1 = actorSystem.actorOf(Props[Master],"master")

    //发送消息
    master1 ! "start"

//    master1 ! "stop"
  }
}
