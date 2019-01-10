package RDDAPI

import org.apache.spark.{SparkConf, SparkContext}

class CartesianTest {

}

/**
  * 笛卡尔积
  */
object CartesianTest{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CoalesceTest").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val arr=sc.parallelize(Array(1,2,3,4,5,6))
    val arr2=sc.parallelize(Array(4,5,6,7,8,9))

    val arr3=arr.cartesian(arr2)
    //(1,4)(1,5)(1,6)(1,7)(2,4)(2,5)(2,6)(1,8)(3,4)(3,5)(1,9)(3,6)(2,7)(2,8)(2,9)(3,7)(3,8)(3,9)
    //(4,4)(4,5)(4,6)(5,4)(5,5)(5,6)(6,4)(6,5)(6,6)(4,7)(4,8)(4,9)(5,7)(5,8)(5,9)(6,7)(6,8)(6,9)
    arr3.foreach(print)
  }
}
