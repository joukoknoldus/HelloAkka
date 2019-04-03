import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext

import scala.concurrent.Await
import scala.util.{Failure, Success}

object Server extends App {

  println("Hello")

  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  Http().bindAndHandle(route, host, port)

  import akka.http.scaladsl.server.Directives._
  def route = path("hello") {
    get {
      complete("Hello, World!")
    }

  }

}
