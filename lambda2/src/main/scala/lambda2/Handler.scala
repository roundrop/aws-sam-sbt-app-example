package lambda2

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import common.Something

class Handler extends RequestHandler[Any, Unit] {

  def handleRequest(input: Any, context: Context): Unit = {
    println("lambda2: handleRequest start")
    println(input)
    Something.hello
    println("lambda2: handleRequest end")
  }

}
