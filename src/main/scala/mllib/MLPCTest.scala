package mllib

import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession

object MLPCTest {
  def main(args: Array[String]): Unit = {
    // 构建spark对象
    val spark = SparkSession.builder.
      master("local").
      appName("MLPCTest").getOrCreate()

    // 读取以LIBSVM格式存储的数据
    val data = spark.read.format("libsvm").
      load("D:\\BaiduNetdiskDownload\\MLlib机器学习\\数据\\temporData.txt")

    // 拆分成训练集和测试集
    val splits = data.randomSplit(Array(0.8, 0.2), seed = 1234L)
    val train = splits(0)
    val test = splits(1)

    // 指定神经网络的图层：
    // 输入层4个结点(即4个特征)；两个隐藏层，隐藏结点数分别为5和4；输出层3个结点(即分为3类)
    val layers = Array[Int](4, 5, 4, 3)

    // 建立MLPC训练器并设置参数
    val trainer = new MultilayerPerceptronClassifier().
      setLayers(layers).
      setBlockSize(128).
      setSeed(1234L).
      setMaxIter(100)

    // 训练模型
    val model = trainer.fit(train)

    // 用训练好的模型预测测试集的结果
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")

    // 计算误差并输出
    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
    println("Test set accuracy = " + evaluator.evaluate(predictionAndLabels))

    // 输出结果
    result.show(60,false)
  }
}
