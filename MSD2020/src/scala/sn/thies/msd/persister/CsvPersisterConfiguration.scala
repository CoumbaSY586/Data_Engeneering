package sn.thies.msd.persister
import org.apache.spark.sql.{DataFrame, SaveMode}

case class CsvPersisterConfiguration(outputDir: String,
                                     saveMode: Option[String] = None,
                                     header:Option[Boolean] = None,
                                     sep:Option[String] = None,
                                    ) extends Persister {


  val format="csv"
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
      .option("header", header.getOrElse(true))
      .option("sep", sep.getOrElse(","))
      .csv(outputDir)
  }
}


