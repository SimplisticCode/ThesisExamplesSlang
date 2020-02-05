// #Sireum

import org.sireum._

object gcd {
  def gcd(a: Z, b: Z): Z = {
    Contract(
      Requires(a >= 0, b >= 0),
      Ensures((a % Res) == 0,
        (b % Res) == 0
      )
    )
    if (b == 0) {
      if (a < 0) {
        return -a
      }
      return a
    } else {
      return gcd(b, a % b)
    }
  }



}

