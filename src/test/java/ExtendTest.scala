abstract class AA[T](t:T){
  var a:T = t
  val b = 2
}

class AAA[T](c:T) extends AA{
  override val b: Int = 5
}
object AA{
  def main(args: Array[String]): Unit = {
    val aaa = new AAA[Int](c = 3)
    println(aaa.a)
  }
}
