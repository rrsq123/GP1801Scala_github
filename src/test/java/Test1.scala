import scala.collection._
object Test1 {
  def main(args: Array[String]): Unit = {
    def test(a: Any) = a match {
      case a:List[String] => println(s"char.a:${a}");
      case a:List[Char] => println(s"char.a:${a}");
      case a:Set[Char] => println(s"char.a:${a}");
      case _ => println(333)
    }
    test(List("1","2"))
  }
}


