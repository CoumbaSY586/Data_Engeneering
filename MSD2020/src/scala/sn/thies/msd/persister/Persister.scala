package sn.thies.msd.persister

import org.apache.spark.sql.DataFrame

trait Persister {

  def persist(dataFrame: DataFrame): Unit
  val format:String
}



