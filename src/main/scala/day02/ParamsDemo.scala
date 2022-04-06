package day02

/**
  * 参数列表：定长参数列表、变长参数列表
  */
object ParamsDemo {
  def main(args: Array[String]): Unit = {
    //定长参数列表,参数列表中可以使用默认值，如有默认值时,当默认值在参数列表的最后，可以不传递该参数
    def m1(name:String,age:Int,marry:Boolean=false)={
        println(s"name:${name},age:${age},marry:${marry}")
    }

    //定长参数列表 默认值参数在参数列表中间
    def m2(name:String,marry:Boolean=false,age:Int)={
      println(s"name:${name},age:${age},marry:${marry}")
    }

    //变长参数列表
    def m3(name:Array[String]*)={
      println(s"size:"+name.size)
    }

    //变长参数列表 变长参数必须在参数列表的最后,变长参数和给参数默认值不能一起使用
    def m4(name:String,marry:Boolean,age:Int*)={
      println(s"name:${name},age:${age},marry:${marry}")
    }

    //测试
    m1("zs",20)
    m1("zs",20,false)
    m2("zs",true,19)
    val arr1 = Array("1","3")
    val arr2 = Array("5","6")
    m3(arr1,arr2)
    m4("ww",true,10,20,30,40,50)

    /**
      * 变长参数：
      * 1、参数列表可以给默认值，默认值在最后的，调用改参数可不传
      * 2、变长使用*，只能放最后,不能有多个变长参数
      * 3、变长参数不能和默认值一起使用
      */
  }
}
