package breezeApi

import breeze.linalg.{DenseMatrix, DenseVector}

/**
  * 矩阵或向量分别与数值的计算
  * 规则1:累加效果，加等号
  *
  * 注意：乘除号前不需要冒号，因为没有矩阵与数值的点积等计算
  */
object MatrixAndVectorWithNumber {
  def main(args: Array[String]) {
    val v1 = DenseVector(1.0, 2.0, 3.0, 4.0)

    // DenseVector(1.5, 2.5, 3.5, 4.5)
    println("v1 + 0.5 : ")
    println(v1 + 0.5)

    // DenseVector(0.5, 1.5, 2.5, 3.5)
    println("\nv1 - 0.5 : ")
    println(v1 - 0.5)

    // DenseVector(0.5, 1.0, 1.5, 2.0)
    println("\nv1 * 0.5 : ")
    println(v1 * 0.5)

    // DenseVector(2.0, 4.0, 6.0, 8.0)
    println("\nv1 / 0.5 : ")
    println(v1 / 0.5)

    // v1依然不变
    // DenseVector(1.0, 2.0, 3.0, 4.0)
    println("\nv1 : ")
    println(v1)

    // DenseVector(1.5, 2.5, 3.5, 4.5)
    println("\nv1 += 0.5 : ")
    println(v1 += 0.5)

    // DenseVector(1.0, 2.0, 3.0, 4.0)
    println("\nv1 -= 0.5 : ")
    println(v1 -= 0.5)

    // DenseVector(0.5, 1.0, 1.5, 2.0)
    println("\nv1 *= 0.5 : ")
    println(v1 *= 0.5)

    // DenseVector(5.0, 10.0, 15.0, 20.0)
    println("\nv1 /= 0.1 : ")
    println(v1 /= 0.1)

    // DenseVector(5.0, 10.0, 15.0, 20.0)
    println("\nv1 : ")
    println(v1)

    val m1 = DenseMatrix((1.0, 2.0), (3.0, 4.0))

    /**
      * 1.5  2.5
      * 3.5  4.5
      */
    println("m1 + 0.5 : ")
    println(m1 + 0.5)

    /**
      * 0.5  1.5
      * 2.5  3.5
      */
    println("\nm1 - 0.5 : ")
    println(m1 - 0.5)

    /**
      * 0.5  1.0
      * 1.5  2.0
      */
    println("\nm1 * 0.5 : ")
    println(m1 * 0.5)

    /**
      * 2.0  4.0
      * 6.0  8.0
      */
    println("\nm1 / 0.5 : ")
    println(m1 / 0.5)

    // m1依然不变
    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 : ")
    println(m1)

    /**
      * 1.5  2.5
      * 3.5  4.5
      */
    println("\nm1 += 0.5 : ")
    println(m1 += 0.5)

    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 -= 0.5 : ")
    println(m1 -= 0.5)

    /**
      * 0.5  1.0
      * 1.5  2.0
      */
    println("\nm1 *= 0.5 : ")
    println(m1 *= 0.5)

    /**
      * 5.0   10.0
      * 15.0  20.0
      */
    println("\nm1 /= 0.1 : ")
    println(m1 /= 0.1)

    /**
      * 5.0   10.0
      * 15.0  20.0
      */
    println("\nm1 : ")
    println(m1)
  }
}
