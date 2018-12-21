package sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable

/**
  * 找共同好友，前提是你们需要是好友，不然共同好友是没有意义的。
  * 主：好友1 好友2 好友3 好友4....
  * 策略：（（主和好友1），（所有好友））
  * 以（主和好友）为key合并，求交集
  */
object OpenFriends {
  def main(args: Array[String]): Unit = {
    if (args.size < 2) {
      println("Usage: FindCommonFriends <input-dir> <output-dir>")
      sys.exit(1)
    }
    //输入路径
    val inputPath = ""
    //输出路径
    val outputPath = ""
    //测试环境使用1个内核处理即可，生产环境中进行修改
    val sparkConf: SparkConf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("FindCommonFriends")
    val sc: SparkContext = SparkContext.getOrCreate(sparkConf)

    val records: RDD[String] = sc.textFile(inputPath)
    //映射两两组合键值对
    val pairs: RDD[((String, String), Seq[String])] = records.flatMap(s => {
      val tokens: Array[String] = s.split(",")
      val person: String = tokens(0)
      val friends: Seq[String] = tokens(1).split(" ").toList
      val result: Seq[((String, String), Seq[String])] = for {
        i <- 0 until friends.size
        friend = friends(i)
      } yield {
        if (person < friend)
          ((person, friend), friends)
        else
          ((friend, person), friends)
      }
      result
    })

    //共同好友计算
    val commonFriends: RDD[((String, String), immutable.Iterable[String])] = pairs
      .groupByKey()
      .mapValues(iter => {
        val friendCount = for {
          list <- iter
          if !list.isEmpty
          friend <- list
        } yield ((friend, 1))
        //friendCount.groupBy(_._1).mapValues(_.unzip._2.sum).filter(_._2 > 1).map(_._1)
        friendCount.groupBy(_._1).map(x=>(x._1,x._2.toList.length)).filter(_._2>1).map(_._1)
      })

    //保存结果
    // commonFriends.saveAsTextFile(outputPath)

    //打印共同好友结果
    val formatedResult = commonFriends.map(
      f => s"(${f._1._1}, ${f._1._2})\t${f._2.mkString("[", ", ", "]")}"
    )

    formatedResult.foreach(println)
    sc.stop()
  }
}
