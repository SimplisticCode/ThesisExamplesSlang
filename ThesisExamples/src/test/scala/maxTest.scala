import org.scalatest._
import org.sireum._

class maxTest extends FunSuite {
  test("Test from dafny - Rise4Fun") {

    val b_module = B_module()
    val result = b_module.Max(10, 20)
    assert(result == 20)
  }
}
