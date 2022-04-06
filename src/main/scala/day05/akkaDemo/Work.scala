package day05.akkaDemo

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

/**
  * 从节点
  */
class Work extends Actor {
  //可以选择重写，在recive方法执行之前仅执行一次
  override def preStart(): Unit = {
    //在worker线程中向master中发送信息
    val master:ActorSelection = context.actorSelection("akka.tcp://MasterSystem@localhost:6666/user/master")
    println(master.pathString)
    master ! "connect"
    println("prestart function start...")
  }
  //重复执行
  override def receive: Receive = {
    case "self" => println("接收到自己发送给自己的消息")
    case "reply" => println("接收到master线程的返回信息Reply")
  }
}
//测试
object Work{
  def main(args: Array[String]): Unit = {
    //配置主机和ip信息
    val host = "localhost"
    val port = 9999

    val config_str =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
         """.stripMargin //该定义使用|来去分割

    //将配置信息构建成config对象
    val config:Config = ConfigFactory.parseString(config_str)

    //创建Akka的actor对象
    val actorSystem = ActorSystem("WorkSystem",config)
    val work = actorSystem.actorOf(Props(new Work()),"work")

    //work发送给自己信息
    work ! "self"

    //关闭
//    https://blog.csdn.net/qq_28666339/article/details/7918364779183647
  }
}
