package sn.thies.msd.reader

import org.apache.spark.sql.{DataFrame, SparkSession}

trait ReaderConfiguration {

  val format: String
  def read()(implicit spark: SparkSession): DataFrame
}
