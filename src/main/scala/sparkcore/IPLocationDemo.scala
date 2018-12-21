package sparkcore

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 输入Ip,查看归属地
  * ip2Long方法：将ip转为十进制，注意：ip为16进制.关注优先级哈
  * binarySearch方法：二分法查找
  * 注意广播，为啥广播？因为规则要广播到每一个节点，不然规则不全嘞。
  * 
  */
object IPLocationDemo {
  def ip2Long(ip: String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length){
      ipNum =  fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  def binarySearch(lines: Array[(String, String, String)], ip: Long) : Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high) / 2
      if ((ip >= lines(middle)._1.toLong) && (ip <= lines(middle)._2.toLong))
        return middle
      if (ip < lines(middle)._1.toLong)
        high = middle - 1
      else {
        low = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[2]").setAppName("IpLocation")
    val sc = new SparkContext(conf)

    val ipRulesRdd = sc.textFile("c://ip.txt").map(line =>{
      val fields = line.split("\\|")
      val start_num = fields(2)
      val end_num = fields(3)
      val province = fields(6)
      (start_num, end_num, province)
    })
    //全部的ip映射规则
    val ipRulesArrary = ipRulesRdd.collect()

    //广播规则
    val ipRulesBroadcast = sc.broadcast(ipRulesArrary)

    //加载要处理的数据
    val ipsRDD = sc.textFile("c://access_log").map(line => {
      val fields = line.split("\\|")
      fields(1)
    })

    val result = ipsRDD.map(ip => {
      val ipNum = ip2Long(ip)
      val index = binarySearch(ipRulesBroadcast.value, ipNum)
      val info = ipRulesBroadcast.value(index)
      info
    })

    println(result.collect().toBuffer)

    sc.stop()
  }
}
