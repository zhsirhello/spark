package breezeApi
import breeze.linalg.DenseMatrix
import breeze.numerics.{pow, sqrt}

/**
  * \n次方与开方
  */
object PowAndQurt {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    /**
      * 1.0  4.0
      * 9.0  16.0
      */
    println(pow(m1, 2))

    /**
      * 1.0   8.0
      * 27.0  64.0
      */
    println(pow(m1, 3))

    /**
      * 1.0                 1.4142135623730951
      * 1.7320508075688772  2.0
      */
    println(sqrt(m1))
  }
}
