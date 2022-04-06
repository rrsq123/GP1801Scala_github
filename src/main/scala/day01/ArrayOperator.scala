package day01

/**
  * 数组的简单操作
  */
object ArrayOperator {
  def main(args: Array[String]): Unit = {
    val arr = Array(6,3,4,5,2,7,8)

    //对每个元素*10
    val res = for (i <- arr) yield i*10
    for (i <- res)
      print(i +" ")
    println()

    val arr1 = arr.map(_ * 10)
    println(arr1.toBuffer)

    //过滤arr中的偶数
    val arr2 = arr.filter(_ % 2 == 0)
    println(arr2.toBuffer)
    for (i <- arr if( i%2==0 ))
      print(i+" ")
    println()

    //总计
    println(arr.sum)

    //最大
    println(arr.max)

    //排序
    val sort1 = arr.sorted
    val sort2 = sort1.reverse
    println(sort1.toBuffer)
    println(sort2.toBuffer)

//    arr2.foldLeft()
  }
}
