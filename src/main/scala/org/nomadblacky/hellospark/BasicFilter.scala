package org.nomadblacky.hellospark

import org.apache.spark.{SparkConf, SparkContext}

object BasicFilter {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("BasicFileter").setMaster("local")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("SPARK_README.md")
    val filteredLines = textFile.filter(_.contains("Scala"))

    filteredLines.saveAsTextFile("target/result/filter")
  }
}
