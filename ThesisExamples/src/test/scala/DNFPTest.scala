import org.scalatest._
import org.sireum._

class DNFPTest extends FunSuite {
  test("Simple test") {
    val input: ISZ[Z] = ISZ(2, 2, 1, 1, 0, 0, 0, 1, 1, 2)
    val result = DutchNationalFlag.dutchNationalFlagAlgorithm(input)
    val expectedResult: ISZ[Z] = ISZ(0, 0, 0, 1, 1, 1, 1, 2, 2, 2)
    println(result)
    assert(result == expectedResult)
  }

  test("Test 1") {
    val input: ISZ[Z] = ISZ(0, 1, 1, 0, 0, 0, 1, 1, 2)
    val result = DutchNationalFlag.dutchNationalFlagAlgorithm(input)
    val expectedResult: ISZ[Z] = ISZ(0, 0, 0, 0, 1, 1, 1, 1, 2)
    println(result)
    assert(result == expectedResult)
  }


}
