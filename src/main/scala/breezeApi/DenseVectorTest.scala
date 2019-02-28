package breezeApi

import breeze.linalg.DenseVector

/**
  * 规则1:乘除前面，加冒号；单独的乘号和除号分别表示点积和线性求解
  * 规则2:累加效果，加等号
  */
object DenseVectorTest {
  def main(args: Array[String]) {
    val v1 = DenseVector(1.0, 2.0, 3.0, 4.0)
    val v2 = DenseVector(0.5, 0.5, 0.5, 0.5)
    // DenseVector(1.5, 2.5, 3.5, 4.5)
    println("\nv1 + v2 : ")
    println(v1 + v2)

    // DenseVector(0.5, 1.5, 2.5, 3.5)
    println("\nv1 - v2 : ")
    println(v1 - v2)

    // DenseVector(0.5, 1.0, 1.5, 2.0)
    println("\nv1 :* v2 : ")
    // 规则1：乘号前面多了冒号
    println(v1 :* v2)

    // DenseVector(2.0, 4.0, 6.0, 8.0)
    println("\nv1 :/ v2 : ")
    // 规则1：除号前面多了冒号
    println(v1 :/ v2)

    // 但是v1 和 v2并没有改变
    // DenseVector(1.0, 2.0, 3.0, 4.0)
    println("\nv1 : ")
    println(v1)

    // DenseVector(0.5, 0.5, 0.5, 0.5)
    println("\nv2 : ")
    println(v2)

    // 规则2
    // 如果想把最后的结果保存到v1上，需要加等号
    // DenseVector(1.5, 2.5, 3.5, 4.5)
    println("\nv1 += v2 : ")
    println(v1 += v2)

    // DenseVector(1.0, 2.0, 3.0, 4.0)
    println("\nv1 -= v2 : ")
    println(v1 -= v2)

    // DenseVector(0.5, 1.0, 1.5, 2.0)
    println("\nv1 :*= v2 : ")
    // 注意：乘号前面多了冒号
    println(v1 :*= v2)

    // DenseVector(1.0, 2.0, 3.0, 4.0)
    println("\nv1 :/= v2 : ")
    // 注意：除号前面多了冒号
    println(v1 :/= v2)
  }
}
