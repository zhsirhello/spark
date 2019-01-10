package RDDAPI

import org.apache.spark.{SparkConf, SparkContext}

object AggregateTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Test").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val arr=sc.parallelize(Array("abc","b","c","d","e","f"))
    val result = arr.aggregate("kkk")((value,word)=> value+word,_+_)
    //kkkkkkabcbckkkdef
    println(result)
  }
}
