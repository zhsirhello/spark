package structure

import org.apache.spark.sql.SparkSession

/**
  * Dataset的入门使用
  */
object DateSetSimpleUse {
  def main(args: Array[String]) {
    //入口
    val sparkSession = SparkSession.builder.
      master("local")
      .appName("example")
      .getOrCreate()
    //引入隐式转换，as[String]是转换为DataSet
    import sparkSession.implicits._
    val data = sparkSession.read.text("E:\\spartTest\\structure.txt").as[String]


    val words = data.flatMap(value => value.split("\\s+"))

    val groupedWords = words.groupByKey(_.toLowerCase)

    val counts = groupedWords.count()

    counts.show()

  }
}
