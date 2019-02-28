package breezeApi

import breeze.linalg.{Axis, DenseMatrix}
import breeze.stats.mean

/**
  * 求和之后均值转化成向量
  */
object MatrixMean {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    // Axis._0 纵向
    // 2.0  3.0
    println(mean(m1, Axis._0))

    // Axis._1 横向
    // 1.5  3.5
    println(mean(m1, Axis._1))
  }
}
