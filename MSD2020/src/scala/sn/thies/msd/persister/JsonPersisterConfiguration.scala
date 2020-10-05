package sn.thies.msd.persister

import org.apache.spark.sql.{DataFrame, SaveMode}


case class JsonPersisterConfiguration(outputDir: String,
                                      saveMode: Option[String] = None,
                                    ) extends Persister{


  val format: String = "json"

  def persist(dataFrame: DataFrame): Unit = {
    val savemode = saveMode.getOrElse("o") match {
      case "a" => SaveMode.Append
      case "o" => SaveMode.Overwrite
      case "e" => SaveMode.ErrorIfExists
      case _ => SaveMode.Append
    }
    dataFrame
      .repartition(1)
      .write
      .mode(savemode)
      .json(outputDir)

  }
}