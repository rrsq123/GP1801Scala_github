package day02

/**
  * 拉链操作：将两个或者多个集合进行合并
  */
object ZipDemo {
  def main(args: Array[String]): Unit = {
    val names:Array[String] = Array("二狗","麻子")
    val ages = Array(33,50,23)
    val sex = Array(1,1,2,1)
    //将两个集合绑定，如果数组长度不一致，将会以短的为准
    val namesAges:Array[(String,Int)] = names.zip(ages)
    //names不足补"*"，然后ages不足补0
    val namesAges1:Array[(String,Int)] = names.zipAll(ages,"*",0)
    //为单个数组捆绑下标
    val namesAges2:Array[(Int,Int)] = sex.zipWithIndex

    //解拉链
    val (arr1,arr2) = namesAges.unzip
    val arr3 = namesAges.unzip

    println(namesAges.toBuffer)
    println(namesAges1.toBuffer)
    println(namesAges2.toBuffer)

    println(arr1.toBuffer)
    println(arr2.toBuffer)
    println(arr3._1.toBuffer)
    println(arr3._2.toBuffer)
    //遍历解拉链出来的数据
    /*for ((arr1,arr2) <- nameAndAge){
      println(arr1)
      println(arr2)
    }*/
  }
}
