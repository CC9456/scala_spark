import org.apache.spark.graphx.{Edge, Graph, VertexId}
import org.apache.spark.{SparkContext, _}
import org.apache.spark.rdd.RDD

object Test0715 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sc = new SparkContext("local", "test", conf)

    val users: RDD[(VertexId, (String, String))] =
      sc.parallelize(Array((3L, ("rxin", "student")), (7L, ("jgonzal", "postdoc")),
        (5L, ("franklin", "prof")), (2L, ("istoica", "prof"))))

    val relationships: RDD[Edge[String]] =
      sc.parallelize(Array(Edge(3L, 7L, "collab"), Edge(5L, 3L, "advisor"),
        Edge(2L, 5L, "colleague"), Edge(5L, 7L, "pi")))

    val defaultUser = ("John Doe", "Missing")

    val graph = Graph(users, relationships, defaultUser)
    graph.triplets.collect().foreach(println)



  }

}
