package sn.thies.msd.arguments
import com.beust.jcommander.{JCommander, Parameter}
object Args {

  @Parameter(
    names = Array("-r", "--reader-file-path"),
    description = "Reader configuration file path",
    required = true)
  var readerConfigurationFile: String = _

  @Parameter(
    names = Array("-p", "--persister-file-path"),
    description = "Persister configuration file path",
    required = true)
  var persisterConfigurationFile: String = _

  @Parameter(
    names = Array("-rt", "--reader-type"),
    description = "Reader type ",
    required = true)
  var readertype: String = _


  @Parameter(
    names = Array("-pt", "--persister-type"),
    description = "Persister type",
    required = true)
  var persistertype: String = _



  def parseArguments(args: Array[String]) = {
    new JCommander(this, args.toArray: _*)
  }
}


