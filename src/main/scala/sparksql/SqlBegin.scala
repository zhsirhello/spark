package sparksql

import org.apache.spark.{SparkConf, SparkContext}

/**
  * df.show()显示的什么样子的数据？
  */
object SqlBegin {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sql").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

   /* val df = sqlContext.read.json("E:\\spartTest\\jsonData.json")*/
    val df = sqlContext.read.format("json").load("E:\\spartTest\\jsonData.json")
    df.show()
  }
}
