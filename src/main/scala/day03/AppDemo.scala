package day03

/**
  * scala中同样有程序的主函数，通常写在object中，
  * 但是也可以不用在object中写main函数也可以运行，不推荐该方法，方便测试
  * 如果不写main函数，快速测试，需要继承APP
  * 因为main函数是一个静态的方法，所以就需要写在object中，因object中是静态的，而类不是
  */
object AppDemo extends App {
  println("this is not main.but has app")
}
