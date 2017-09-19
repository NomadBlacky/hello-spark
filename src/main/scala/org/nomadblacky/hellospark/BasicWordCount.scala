package org.nomadblacky.hellospark

import org.apache.spark.{SparkConf, SparkContext}

object BasicWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Basic WordCount").setMaster("local")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("SPARK_README.md")
    val words = textFile.flatMap(_.split(" "))
    val wordCounts = words.map((_, 1)).reduceByKey(_ + _)

    wordCounts.saveAsTextFile("target/result/wordcounts")
  }
}
