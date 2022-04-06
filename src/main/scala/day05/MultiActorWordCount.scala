package day05

import scala.actors.{Actor, Future}
import scala.io.Source
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 使用多线程统计词频
  * 1、统计每一个文件的词频
  * 2、将所有文件词频进行汇总
  */
//封装文件路径的对象
case class SourceFile(FilePath:String)
//封装每一个文件的词频统计值，并将该对象作为线程的返回值
case class FileWordCount(word_map:Map[String,Int])
//停止线程的封装
case object Stop1
//自定义线程
class MultiActorWordCount extends Actor{
  override def act(): Unit = {
    loop(react{
      case SourceFile(path) =>{ //匹配数据源路径封装对象
        //获取路径，得到该路径文件的每一行内容，并且将每一行转换为数组
        val lines_to_arr:Array[String] = Source.fromFile(path).getLines().toArray
        //使用flatmap进行分割
        val lines_word_arr:Array[String] = lines_to_arr.flatMap(_.split(" "))
        //将分割后单词进行映射
        val lines_word_1:Array[(String,Int)] = lines_word_arr.map((_,1))
        //分组
        val lines_word_group:Map[String,Array[(String,Int)]] = lines_word_1.groupBy(_._1)
        //求分组后每个key对应的Array[(String,Int)的size
        val word_count:Map[String,Int] = lines_word_group.mapValues(_.size)
        //将最终的统计结果返回给主线程
        sender ! FileWordCount(word_count)
      }
      case Stop =>{
        exit() //退出线程
      }
    })
  }
}

//测试
object MultiActorWordCount{
  def main(args: Array[String]): Unit = {


    //定义两个路径
    val path_arr:Array[String] = Array("E:\\scaladata\\test.txt","E:\\scaladata\\test1.txt")
    //定义一个用于存储每一个线程返回的结果集
    val resultSet = new mutable.HashSet[Future[Any]]()
    //定义一个用于存储每一文件的词频的List
    val allFileWordList = new ListBuffer[FileWordCount]

    //循环文件路径数组，并创建子线程去统计词频
    var wordActor = new MultiActorWordCount()
      for(file <- path_arr){
      //创建子线程
       wordActor = new MultiActorWordCount()
      //启动子线程
      wordActor.start()
      //向子线程发送信息
      val result:Future[Any] = wordActor !! SourceFile(file) //异步发送

      //将结果接收，并存储到resultSet
//      resultSet.add(result)
      resultSet += result
    }
    //for完成就代表两个线程的结果都返回，并放到resutset中
    while (resultSet.size > 0){
      //过滤线程返回的每一个结果，并判断是否有效
      val finalResultSet = resultSet.filter(_.isSet) //_.isSet：true代表真的返回
      //循环最终finalResultSet
      for(res <- finalResultSet){
        val r = res.apply()
        //再根据类判断
        if(r.getClass == classOf[FileWordCount]){
          //将返回对象转换成FileWordCount对象，并添加到集合里面
          allFileWordList += r.asInstanceOf[FileWordCount]
          //将resultset中的移除
          resultSet -= res
        }
      }
    }
//    allFileWordList = ListBuffer(("hello",1),("world",2)   ("hello",3))
    //代码走到这儿，代表所有的返回结果都被转换成FileWordCount，并放到集合中
    val files_word_count:ListBuffer[(String,Int)] = allFileWordList.flatMap(_.word_map)
    files_word_count.foreach(f=>println(f))
    val files_word_count_group = files_word_count.groupBy(_._1)
    // {("hi":(("hi",1),("hi",1)),"hello",(("hello",1),("hello",1)),"world",((world,2))}
//    files_word_count_group.mapValues(_.size)
    /*println(List(1,2,3).foldLeft(0)((sum,i)=>{
      println(sum+i);
      sum+i
    }))*/
    val word_count:Map[String,Int] = files_word_count_group.mapValues(f=>f.foldLeft(0)(_ + _._2))
    //循环
    for((k,v) <- word_count){
      println(s"k:$k,v:$v")
    }

    //关闭线程
    wordActor ! Stop1
  }
}