package day04

import scala.io.Source

/**
  * scala中的隐式视图：隐式转换函数
  * 隐式转换函数必须引入函数所在的区域
  * */

//读取文件
class ReadFile{
  def readFile(filePath:String):String = {
    Source.fromFile(filePath).mkString
  }
}
//显示文件类
class ShowFile{
  def getFilePath(): String ={
    "E:\\scaladata\\test.txt"
  }
  //显示文件内容
  def showFileData(data:String): Unit ={
    println(data)
  }
}
//隐式转换函数
object ImplictMethod{
  implicit def showFile2ReadFile(sf:ShowFile) = {
    new ReadFile
  }
}

//测试
object ImplictView {
  def main(args: Array[String]): Unit = {
    //单词计数
   /* val arr = Array("hello", "hadoop", "spark","hadoop")
    val str:String = "hello hadoop spark hadoop"
    //(spark,(spark:1)) (hadoop,(hadoop,1)(hadoop:1))
    println(arr.map((_,1)).groupBy(_._1).mapValues(_.size))*/

    //正常读取
    /*val showFile = new ShowFile
    val path = showFile.getFilePath()
    val data = new ReadFile().readFile(path)
    showFile.showFileData(data)*/

    //隐式转换函数
    //使用隐式转换函数需要引入隐式函数所在的区域
    import ImplictMethod._
    val showFile = new ShowFile
    val path = showFile.getFilePath()
    val data = showFile.readFile(path)
    println(data)
  }
}
