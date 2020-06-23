package lambda1

import org.scalatest._
import flatspec._
import matchers._

class HandlerSpec extends AnyFlatSpec with should.Matchers {

  "Lambda1 handler" should "print something" in {
    val handler = new Handler

    val event = "a"
    val context = new TestContext

    handler.handleRequest(event, context)
  }

}
