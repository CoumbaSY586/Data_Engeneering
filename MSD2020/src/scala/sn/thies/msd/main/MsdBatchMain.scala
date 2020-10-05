package sn.thies.msd.main
import org.apache.spark.sql.SparkSession
import sn.thies.msd.arguments.Args
import sn.thies.msd.parser.ConfigurationParser

object MsdBatchMain {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = SparkSession
      .builder
      .appName("MSD")
      .config("spark.master", "local")
      .getOrCreate()
       Args.parseArguments(args)


    val reader = Args.readertype match {
      case "csv" =>
        ConfigurationParser.getCsvReaderConfigurationFromJson(Args.readerConfigurationFile)
      case "json" =>
        ConfigurationParser.getJsonReaderConfigurationFromJson(Args.readerConfigurationFile)
      case "xml" =>
        ConfigurationParser.getXmlReaderConfigurationFromJson(Args.readerConfigurationFile)
      case _ => throw new Exception("Invalid reader type. Supported reader format : csv, json and xml")
    }

    //reader.read().show()

    val persiter=Args.persistertype match {
      case "csv" =>
        ConfigurationParser.getCsvPersisterConfigurationFromJson(Args.persisterConfigurationFile)
      case "json" =>
        ConfigurationParser.getJsonPersisterConfigurationFromJson(Args.persisterConfigurationFile)
      case "xml" =>
        ConfigurationParser.getXmlPersisterConfigurationFromJson(Args.persisterConfigurationFile)
      case _ => throw new Exception("Invalid persiter  type. Supported reader format : csv, json and xml")
    }
    persiter.persist( reader.read())

  }
}
