package day01

/**
  * scala中数组分为:定长数组和变长数组
  */
object SelectLengthArray {
  def main(args: Array[String]): Unit = {
    //使用new 创建创建定长8的数组，默认值和类型相关
    val arr1 = new Array[Int](8)

    println(arr1) //打印地址
    println(arr1.toBuffer) //将数组的值放到buffer

    //不使用new方式来定义变长数组，Array定义，实则用Array的apply()方法
    val arr2 = Array[Int](8) //赋值元素为8
    println(arr2.toBuffer) //

    //定义数组并赋值
    val arr3 = Array(666,123,456,678,"hello")
    println(arr3.toBuffer)

   //操作可变数组
    var arr4 = new Array[String](3)
    arr4(0) = "hello world"
    arr4(1) = "helllo scala"
    arr4(2) = "helllo spark"  //赋值
    println(arr4.toBuffer)

    arr4(1) = "scala scala" //修改值
    println(arr4.toBuffer)
    arr4.update(1,"aaaa")  //修改值
    println(arr4.toBuffer)

    //取元素
    println(arr4(1))
    println(arr4.apply(1))

    //遍历
    for(i <- arr4)
      print(i+ "  ")
    println()

    //将array转换成list,如果数组想删除，需要转换成list
    val li:List[String] = arr4.toList
    println(li)
    val li1 = li.drop(1)
    println("==="+li1.tail) //tail是取集合从后往前的除第一个以外的元素
    println(li1)

    val li2 = Array(1,2,3,4,5)
    println(li2.tail.toBuffer)

    /**
      * 定长数组一般用两种方式定义:new Array[A](8) 或者 Array(元素)
      * 由于定长数组是固定长度，所以不能对其增删
      */
  }
}
