package breezeApi

import breeze.linalg.{Axis, DenseMatrix, sum}

/**
  * 矩阵求和，转化为向量
  */
object MatrixSum {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    // Axis._0 纵向
    // 4.0  6.0
    println(sum(m1, Axis._0))

    // Axis._1 横向
    // 3.0 7.0
    println(sum(m1, Axis._1))
  }
}
