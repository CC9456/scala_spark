import org.apache.spark.{SparkContext,SparkConf}

object test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cx").setMaster("local")
    val sc = new SparkContext(conf)
  }

}
