package breezeApi
import breeze.linalg.DenseMatrix
import breeze.numerics.{exp, log, log10, log1p}

/**
  * e和log的计算
  */
object EAndLog {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    /**
      * 2.718281828459045   7.38905609893065
      * 20.085536923187668  54.598150033144236
      */
    // e = 2.718281828459045
    println(exp(m1))

    /**
      * 0.0                 0.6931471805599453
      * 1.0986122886681098  1.3862943611198906
      */
    // 以e为底
    println(log(m1))

    /**
      * 0.0                  0.3010299956639812
      * 0.47712125471966244  0.6020599913279624
      */
    // 以10为底
    println(log10(m1))

    /**
      * 0.6931471805599453  1.0986122886681096
      * 1.3862943611198906  1.6094379124341003
      */
    // 以e为底
    // log1p() 以返回 log(1 + x)，甚至当 x 的值接近零也能计算出准确结果。
    println(log1p(m1))
  }
}
