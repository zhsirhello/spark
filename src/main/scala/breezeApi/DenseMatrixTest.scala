package breezeApi

import breeze.linalg.DenseMatrix

object DenseMatrixTest {
  def main(args: Array[String]) {
    val m1 = DenseMatrix((1.0, 2.0), (3.0, 4.0))
    val m2 = DenseMatrix((0.5, 0.5), (0.5, 0.5))


    /*1.5  1.5
    3.5  3.5*/
    println(m1*m2)

    /*/**
      * 1.5  2.5
      * 3.5  4.5
      */
    println("\nm1 + m2 : ")
    println(m1 + m2)

    /**
      * 0.5  1.5
      * 2.5  3.5
      */
    println("\nm1 - m2 : ")
    println(m1 - m2)

    /**
      * 0.5  1.0
      * 1.5  2.0
      */
    println("\nm1 :* m2 : ")
    // 注意：乘号前面多了冒号
    println(m1 :* m2)

    /**
      * 2.0  4.0
      * 6.0  8.0
      */
    println("\nm1 :/ m2 : ")
    // 注意：除号前面多了冒号
    println(m1 :/ m2)

    // 但是m1 和 m2并没有改变
    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 : ")
    println(m1)

    /**
      * 0.5  0.5
      * 0.5  0.5
      */
    println("\nm2 : ")
    println(m2)

    // 如果想把最后的结果保存到m1上，需要加等号
    /**
      * 1.5  2.5
      * 3.5  4.5
      */
    println("\nm1 += m2 : ")
    println(m1 += m2)

    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 -= m2 : ")
    println(m1 -= m2)

    /**
      * 0.5  1.0
      * 1.5  2.0
      */
    println("\nm1 :*= m2 : ")
    // 注意：乘号前面多了冒号
    println(m1 :*= m2)
    println("\nm1: ")
    println(m1)
    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 :/= m2 : ")
    // 注意：除号前面多了冒号
    println(m1 :/= m2)*/
  }
}
