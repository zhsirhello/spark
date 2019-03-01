package breezeApi
import breeze.linalg.DenseVector
import breeze.numerics._

/**
  * 取整
  */
object GetNumber {
  def main(args: Array[String]) {
    val a = DenseVector(1.4, 0.5, -2.3)

    // 四舍五入
    println(round(a))

    // 向上取整
    println(ceil(a))

    // 向下取整
    println(floor(a))

    // 大于0，为1；小于0，为-1
    println(signum(a))

    // 绝对值
    println(abs(a))
  }
}
