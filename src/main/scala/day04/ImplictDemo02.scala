package day04

/**
  * 隐式转换函数：
  */
/*//定义一个超人类
class SuperMan{
  def doWhat(order:String)={
    println("我是超人，维护世界和平.指令是:"+order)
  }
}

//蜘蛛侠类
class SpiderMan {
  def sayWath(order:String):String = {
    order
  }
}*/

//特殊人群
class Sepcail(val name:String,val idCard:String){
}
//老年人
class Older(val name:String,val idCard:String) {
  def getOlder()={
    println(s"name:$name,idCard:$idCard")
  }
}

//孩子
class Childer(val name:String,val idCard:String) {
  def getChild()={
    println(s"name:$name,idCard:$idCard")
  }
}

//青年
class Young(val name:String,val idCard:String) {
  def getYoung()={
    println(s"name:$name,idCard:$idCard")
  }
}

//军人
class Soldier(val name:String,val idCard:String) {
  def getSoldier()={
    println(s"name:$name,idCard:$idCard")
  }
}

//军人
class Student(val name:String,val idCard:String) {
  def getStudent()={
    println(s"name:$name,idCard:$idCard")
  }
}

//隐式区域
object ImplictDemo01{
  //定义隐式函数
  implicit def people2Sepcail(obj:Any):Sepcail ={
    if(obj.getClass == classOf[Older]){
      val older = obj.asInstanceOf[Older]
      new Sepcail(older.name,older.idCard)
    } else if(obj.getClass == classOf[Childer]){
      val child = obj.asInstanceOf[Childer]
      new Sepcail(child.name,child.idCard)
    } else if(obj.getClass == classOf[Young]){
      val young = obj.asInstanceOf[Young]
      new Sepcail(young.name,young.idCard)
    } else if(obj.getClass == classOf[Soldier]){
      val soldier = obj.asInstanceOf[Soldier]
      new Sepcail(soldier.name,soldier.idCard)
    } else {
      null //其它人
    }
  }
}

//测试
object ImplictDemo02Test{
  var ticktCount = 0
  //定义普通方法
  def byTickt(specail:Sepcail): Unit ={
    if(specail != null){
      ticktCount += 1
      println(s"请确认您的信息。名字:${specail.name},id信息为:${specail.idCard}")
      Thread.sleep(1000L)
      println("出票成功")
    } else {
      println("非特殊人群")
    }
    println("===========================================")
  }

  def main(args: Array[String]): Unit = {

    //引入隐式区域
    import ImplictDemo01._
    val ch = new Childer("小王","110")
    byTickt(ch)//rh:它会先去将ch直接传入byTickt方法中执行，发现传入的参数类型不匹配，无法执行
            //然后它就会去找隐式函数执行，隐式函数收到了参数(ch对象）并将其转换成Specia类的对象并返回给调用者。
            //byTickt收到这个新的参数（Specia类的对象），发现类型匹配了，然后继续执行
    val old = new Older("老王","111")
    byTickt(old)

    val stu = new Student("学王","112")
    byTickt(stu)

  }
}