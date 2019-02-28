package breezeApi

import breeze.linalg.{*, DenseMatrix, DenseVector}

/**
  * 规则1:乘除前面，加冒号；单独的乘号和除号分别表示点积和线性求解
  * 规则2:累加效果，加等号
  * 规则3:必须有星号
  * 规则4:星号在左，逐行；星号在右，逐列；与向量是列向量还是行向量无关
  * 规则5:向量必须是列向量
  */
object MatrixAndVector {
  def main(args: Array[String]) {

    val m1 = DenseMatrix(
      (1.0, 2.0),
      (3.0, 4.0)
    )

    val v1 = DenseVector(1.0, 2.0)
    //    val v1 = DenseVector(1.0, 2.0).t // 运行时异常，规则5，向量必须是列向量
    //    val v1 = DenseVector(1.0, 2.0).t.t // 正确，如果是一个列向量，需要转换成行向量

    // 规则4: 星号在左，逐行；星号在右，逐列
    println("-------------星号在左边，就逐行操作-----------------")

    /**
      * 2.0  4.0
      * 4.0  6.0
      */
    println("\nm1(*, ::) + v1 : ")
    println(m1(*, ::) + v1)

    /**
      * 0.0  0.0
      * 2.0  2.0
      */
    println("\nm1(*, ::) - v1 : ")
    println(m1(*, ::) - v1)

    //    规则1: 乘除前面，加冒号

    /**
      * 1.0  4.0
      * 3.0  8.0
      */
    println("\nm1(*, ::) :* v1 : ")
    println(m1(*, ::) :* v1)

    /**
      * 1.0  1.0
      * 3.0  2.0
      */
    println("\nm1(*, ::) :/ v1 : ")
    println(m1(*, ::) :/ v1)

    println("-------------星号在右边，就逐列操作-----------------")

    /**
      * 2.0  3.0
      * 5.0  6.0
      */
    println("\nm1(::, *) + v1 : ")
    println(m1(::, *) + v1)

    /**
      * 0.0  1.0
      * 1.0  2.0
      */
    println("\nm1(::, *) - v1 : ")
    println(m1(::, *) - v1)

    /**
      * 1.0  2.0
      * 6.0  8.0
      */
    println("\nm1(::, *) :* v1 : ")
    println(m1(::, *) :* v1)

    /**
      * 1.0  2.0
      * 1.5  2.0
      */
    println("\nm1(::, *) :/ v1 : ")
    println(m1(::, *) :/ v1)

    // 无论星号在哪，m1都不会改变
    println("-------------规则2: 累加效果，加等号-----------------")

    // 下面以整除为例，注意星号的位置，一个在左，一个在右

    /**
      * 1.0  2.0
      * 3.0  4.0
      */
    println("\nm1 : ")
    println(m1)

    /**
      * BroadcastedRows(1.0  4.0
      * 3.0  8.0  )
      */
    println("\nm1(*, ::) :*= v1 : ")
    println(m1(*, ::) :*= v1)

    /**
      * 1.0  4.0
      * 3.0  8.0
      */
    println("\nm1 : ")
    println(m1)

    /**
      * BroadcastedColumns(1.0  4.0
      * 1.5  4.0  )
      */
    println("\nm1(::, *) :/= v1 : ")
    println(m1(::, *) :/= v1)

    /**
      * 1.0  4.0
      * 1.5  4.0
      */
    println("\nm1 : ")
    println(m1)
  }
}
