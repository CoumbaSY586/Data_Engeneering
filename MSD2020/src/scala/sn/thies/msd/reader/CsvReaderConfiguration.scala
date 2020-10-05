package sn.thies.msd.reader

import org.apache.spark.sql.{DataFrame, SparkSession}

case class CsvReaderConfiguration(path: String,
                                  delimiter: Option[String] = None,
                                  header:Option[Boolean] = None

                                 )
  extends ReaderConfiguration {
  val format = "csv"

  def read()(implicit  spark2: SparkSession): DataFrame = {

    spark2.sqlContext.read.format(format)
      .option("delimiter", delimiter.getOrElse(","))
      .option("header", header.getOrElse(true))
      .load(path)
  }
}
