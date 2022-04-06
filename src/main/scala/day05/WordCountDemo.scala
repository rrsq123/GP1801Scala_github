package day05

/**
  * scala编写统计
  */
object WordCountDemo {
  def main(args: Array[String]): Unit = {
    //定义数据
    val arr:Array[String] = Array("hello world welcome to sz","welcome to qianfeng bigdata hadoop hadoop hadoop hadoop")
    //调用方法
//    wordcount1(arr)
    wordcount2(arr)


  }
  //1、简介词频统计
  def wordcount1(arr:Array[String]) ={
    val word_count:Map[String,Int] = arr.flatMap(_.split(" ")).
      map((_,1)).groupBy(_._1).mapValues(_.size)
    //打印
    for((k,v) <-word_count)
      println(s"k:$k,v:$v")
  }

  //对第一种方法进行拆解
  def wordcount2(arr:Array[String])={
      //将arr中的所有元素进行切分   flatMap:扁平  ["hello" "world" "welcome" "to" "sz"]
    val words:Array[String] = arr.flatMap(_.split(" "))
    //映射 [("hello",1),("world",1),("welcome",1)...]
    val f = (word:String) => {(word,1)}
    val word_map:Array[(String,Int)] = words.map(f)
    //分组 {("welcome",Array(("welcome",1),("welcome",1))),("to",Array(("to",1),("to",1))),}
    val word_group_map:Map[String,Array[(String,Int)]] = word_map.groupBy(_._1)
    //分组的统计
    //1、 统计每个单词出现的次数
    val word_count:Map[String,Int] = word_group_map.mapValues(_.size)
    word_count.foreach(f=>println(f))

    //2、对出现的次数进行排序
    val word_count_sort:List[(String,Int)] = word_count.toList.sortBy(_._2)
    println("按照value排序==========================")
    word_count_sort.foreach(f=>println(f))


    //3、对value倒序
    val word_count_sort_reverse:List[(String,Int)] = word_count_sort.reverse
    println("按照value倒序==========================")
    word_count_sort_reverse.foreach(f=>println(f))

    //4、取出词频最高的前3名
    val top3:List[(String,Int)] = word_count_sort_reverse.take(3)
    println("top3==========================")
    top3.foreach(f=>println(f))
  }
}
