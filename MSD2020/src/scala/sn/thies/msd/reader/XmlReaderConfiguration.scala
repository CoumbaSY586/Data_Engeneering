package sn.thies.msd.reader

import org.apache.spark.sql.{DataFrame, SparkSession}


case class XmlReaderConfiguration(path: String)


  extends ReaderConfiguration {

  val format  =  "xml"
  def read()(implicit  spark2: SparkSession): DataFrame = {
    spark2.sqlContext.read.format("xml")
      .load(path)
  }
}
