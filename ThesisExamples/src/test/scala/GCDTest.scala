import org.scalatest._
import org.sireum._

class GCDTest extends FunSuite {
  test("GCD") {
    assert(Z(0) == gcd.gcd(0,0))
    assert(Z(2) == gcd.gcd(6,4))
    assert(Z(7) == gcd.gcd(7,21))
    assert(Z(12) === gcd.gcd(12,36))
    assert(Z(11) === gcd.gcd(33,77))
    assert(Z(1) === gcd.gcd(41,47))
    assert(Z(3) === gcd.gcd(99,51))
    assert(Z(5) === gcd.gcd(100,5))
    assert(Z(1) === gcd.gcd(7,23))
    assert(Z(51) === gcd.gcd(1989,867))
    assert(Z(2469) === gcd.gcd(12345,9876))
    assert(Z(34) === gcd.gcd(40902,24140))
    assert(Z(9973) === gcd.gcd(49865,69811))
  }

  test("GCD Tail recursive") {
    assert(Z(0) == gcd.gcd1(0,0))
    assert(Z(2) == gcd.gcd1(6,4))
    assert(Z(7) == gcd.gcd1(7,21))
    assert(Z(12) === gcd.gcd1(12,36))
    assert(Z(11) === gcd.gcd1(33,77))
    assert(Z(1) === gcd.gcd1(41,47))
    assert(Z(3) === gcd.gcd1(99,51))
    assert(Z(5) === gcd.gcd1(100,5))
    assert(Z(1) === gcd.gcd1(7,23))
    assert(Z(51) === gcd.gcd1(1989,867))
    assert(Z(2469) === gcd.gcd1(12345,9876))
    assert(Z(34) === gcd.gcd1(40902,24140))
    assert(Z(9973) === gcd.gcd1(49865,69811))
  }

}
