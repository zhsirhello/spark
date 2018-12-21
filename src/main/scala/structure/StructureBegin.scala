package structure

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.streaming.ProcessingTime
import org.apache.spark.sql.types.{StringType, StructField, StructType}

/**
  * 简单使用，wordcount
  */

class StructureBegin {

}
case class DeviceData(name: String,city: String)
object StructureBegin{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[2]").
      appName("structureWordCount").
      getOrCreate()
    val schemaExp = StructType(
      StructField("name", StringType, true) ::
        StructField("city", StringType, true)
        :: Nil
    )

    //标准的DataSource API，只不过read变成了readStream
    /*val words = spark.readStream.format("text").schema(schemaExp)
      .load("E:\\spartTest")*/
    val words:DataFrame = spark.readStream.format("text")
      .load("E:\\spartTest")


    // DataFrame 的一些API
//    val wordCounts = words.groupBy("name").count()
     import spark.implicits._
    //常规wordcount操作
     val wordCounts = words.as[String].flatMap(_.split(" ")).groupByKey(va=>va).count()

    //标准的DataSource 写入 API，只不过write变成了writeStream
    val query = wordCounts.writeStream
      //complete,append,update。目前只
      //支持前面两种
      .outputMode("complete")
      //console,parquet,memory,foreach 四种
      .format("console")
      .trigger(ProcessingTime(1000))
      .start()

    query.awaitTermination()


  }
}
