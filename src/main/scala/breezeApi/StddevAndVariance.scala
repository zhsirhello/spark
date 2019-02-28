package breezeApi

import breeze.linalg.{Axis, DenseMatrix}
import breeze.stats.{stddev, variance}
object StddevAndVariance {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    // Axis._0 纵向
    // 2.0  2.0
    println(variance(m1, Axis._0))

    // Axis._1 横向
    // 0.5, 0.5
    println(variance(m1, Axis._1))

    // Axis._0 纵向
    // 2.0  2.0
    println(stddev(m1, Axis._0))

    // Axis._1 横向
    // 0.5, 0.5
    println(stddev(m1, Axis._1))
  }
}
