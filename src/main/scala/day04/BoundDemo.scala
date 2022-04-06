package day04

/**
  * 上边界：限定传入的参数类型是某个类型的子类或者本身 def get[T<:A](t:T):Unit= {}
  * 下边界：限定传入的参数类型是某个类型的父类或者本身 def get[T>:A](t:T):Unit = {}
  */

class GrandFather{
  def getGrandFather = {println("============GrandFather=====")}
}
class Father extends GrandFather{
  def getFather = {println("============Father=====")}
}
class Son extends Father{
  def getSon = {println("============Son=====")}
}
//测试
object BoundDemo {
  //下边界
  def downBound[T>:Son](t:T) = {
    if(t.getClass == classOf[Father]){
      val fa = t.asInstanceOf[Father]
      fa.getFather
    } else if(t.getClass == classOf[GrandFather]){
      val gf = t.asInstanceOf[GrandFather]
      gf.getGrandFather
    } else if(t.getClass == classOf[Son]){
      val son = t.asInstanceOf[Son]
      son.getSon
    }
  }

  //上边界
  def upBound[T<:Father](t:T) = {
    if(t.getClass == classOf[Father]){
      val fa = t.asInstanceOf[Father]
      fa.getFather
    } else if(t.getClass == classOf[Son]){
      val s = t.asInstanceOf[Son]
      s.getSon
    }
  }

  def main(args: Array[String]): Unit = {
    //下边界测试 本身或者父类
    val grandFather = new GrandFather
    val father = new Father
    val son = new Son
    downBound[GrandFather](grandFather)
    downBound[GrandFather](son)

    println("==============================")
    //上边界测试  本身或子类
    upBound[Father](father)
    upBound[Son](son)
  }

  /**
    * 调用方法时泛型需要和定义方法时后的泛型比较。
    * 调用方法时，参数需要是泛型的类或者子类
    */
}
