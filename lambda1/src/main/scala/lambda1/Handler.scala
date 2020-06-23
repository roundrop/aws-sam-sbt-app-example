package lambda1

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import common.Something

class Handler extends RequestHandler[Any, Unit] {

  def handleRequest(input: Any, context: Context): Unit = {
    println("lambda1: handleRequest start")
    println(input)
    Something.hello
    println("lambda1: handleRequest end")
  }

}
