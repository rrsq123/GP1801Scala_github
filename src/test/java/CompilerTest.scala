class CompilerTest {
  for (i <- 1 to 10) println(i)
}

object CompilerTest{
  def main(args: Array[String]): Unit = {
    val ct = new CompilerTest
  }
}
