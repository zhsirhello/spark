package sparksql

import org.apache.spark.{SparkConf, SparkContext}

case class PlaceOfRedice(name:String,city:String)
object RDDToDataFrane {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sql").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("E:\\spartTest\\structure.txt").map(_.split(" "))
    val result= rdd.collect()
    println(result)
  }
}
