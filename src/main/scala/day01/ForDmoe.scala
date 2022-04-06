package day01

import scala.util.control.Breaks

/**
  * scala中的循环
  *for(i <- 表达式/数组/结合){循环体}
  * while(条件表达式){循环体}
  * do{循环体}while(条件表达式)
  */
object ForDmoe {
  def main(args: Array[String]): Unit = {
    //to右包，unti不包右
    for (i <- 20 to 30){
      print(i)
    }
    //打印下标和值
    val arr = Array("abc",1,2,"def")
    for (i <- 0 until arr.length){
      println("index:"+i +" value:"+arr(i))
    }

    //双重循环
   /* for(i <- 1 to 5; j <- 1 to 5){
      if(i != j){
        println(i+"!="+j)
      }
    }*/

    //双重循环 带条件时，可以直接将条件放到表达式后面
    for(i <- 1 to 5; j <- 1 to 5 if(i != j)){
      println(i+"!="+j)
    }
    //传统java方式写
    /*for(i <- 1 to 5){
      for(j <- 1 to 5){
        if(i != j){
          println(i+"!="+j)
        }
      }
    }*/
    //for推导 如果for循环的循环体以yeild开始，
    // 则每次循环将执行其yeild语句生成一个对应的值,并将其对应的值封装的list中返回
     val li = for(i <- 1 to 5) yield i*5
    println(li)

    //while
    var i = 1
    while (i <= 5){
      println(i)
      i += 1
    }

    do
      {
        println("do while"+i)
        i += 1
      }
    while (i <= 5)

    //scala中不提供break跳出语句，但是2.8以后可以提供Breaks来实现
    val myBreak = new Breaks()
    myBreak.breakable(
      for(j <- 0 to 10){
        if(j == 6){
          //当i==6时退出整个循环
          println()
          myBreak.break() //退出整个循环
        }
        println("mybreak:"+j)
      })
  }
}