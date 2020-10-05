package sn.thies.msd.reader

import org.apache.spark.sql.{DataFrame, SparkSession}

case class JsonReaderConfiguration(path: String,
                                   multiline: Option[Boolean] = None)

  extends ReaderConfiguration {

  val format = "json"
  def read()(implicit  spark2: SparkSession): DataFrame = {
    spark2.sqlContext.read.format("json")
      .option("multiline", multiline.getOrElse(true))
      .load(path)
  }
}