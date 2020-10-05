package sn.thies.msd.parser

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import sn.thies.msd.reader.{CsvReaderConfiguration, JsonReaderConfiguration, XmlReaderConfiguration}
import sn.thies.msd.persister.{CsvPersisterConfiguration, JsonPersisterConfiguration, XmlPersisterConfiguration}

object ConfigurationParser {
  implicit val format: DefaultFormats.type = DefaultFormats

  def getCsvReaderConfigurationFromJson(jsonString: String): CsvReaderConfiguration = {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[CsvReaderConfiguration]
  }

  def getJsonReaderConfigurationFromJson(jsonString: String): JsonReaderConfiguration = {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[JsonReaderConfiguration]
  }


  def getCsvPersisterConfigurationFromJson(jsonString: String): CsvPersisterConfiguration= {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[CsvPersisterConfiguration]
  }

  def getJsonPersisterConfigurationFromJson(jsonString: String): JsonPersisterConfiguration = {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[JsonPersisterConfiguration]
  }
  def getXmlReaderConfigurationFromJson(jsonString: String): XmlReaderConfiguration = {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[XmlReaderConfiguration]
  }

  def getXmlPersisterConfigurationFromJson(jsonString: String): XmlPersisterConfiguration= {
    JsonMethods.parse(FileReaderUsingIOSource.getContent(jsonString)).extract[XmlPersisterConfiguration]
  }
}
