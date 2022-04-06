/**
  *
  */
class A {
  var a = 20
  val b = a
}

class B extends A {
  override val b: Int = 30
}

object A{
  def main(args: Array[String]): Unit = {
    val b = new B
    println(b.b)
  }
}
