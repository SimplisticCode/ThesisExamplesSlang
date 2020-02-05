// #Sireum

import org.sireum._

//Example from https://rise4fun.com/Dafny/jrJQ
//Presented in http://leino.science/papers/krml248.pdf
/*
abstract module M0 {
  method Abs(x: int) returns (a: int)
    ensures (a == x || a == -x) && x <= a && -x <= a
  {
    if * {
      a := x;
    } else {
      a := 0;
      var b := x;
      while b < 0
      {
        a, b := a + 1, b + 1;
      }
      assume a == -x;
    }
    assume x <= a && -x <= a;
  }
}
abstract module M1 refines M0 {
  method Abs...
  {
    if 0 <= x {
      ...;
    } else {
      ...;
    }
    assert ...;
  }
}
module M2 refines M1 {
  method Abs...
  {
    if ... {
      ...;
    } else {
      ...;
      while ...
        invariant a + x == b <= 0
      {
        ...;
      }
      assert ...;
    }
    ...;
  }
}
*/

//Can we introduce decrease in Slang? Will it be done and can we use it in the same way as we can in Dafny?
//This needs to be verified by Logika

@record trait M0 {
  def Abs(x: Z): Z = {
    Contract(
      Ensures((Res == x || Res == -x) && x <= Res && -x <= Res)
    )
    var a: Z = 0 //Needs to introduce this
    if (x <= 0) { //* {/How to handle this?
      a = x
    } else {
      a = 0
      var b = x
      while (b < 0) {
        a = a + 1
        b = b + 1
      }
      assume(a == -x)
    }
    assume(x <= a && -x <= a)
    return a
  }

}

@record trait M1 extends M0 {
  override def Abs(x: Z): Z = {
    var a: Z = 0 //Needs to introduce this
    if (x <= 0) {
      a = x
    } else {
      a = 0
      var b = x
      while (b < 0) {
        a = a + 1
        b = b + 1
      }
      assume(a == -x)
    }
    assert(x <= a && -x <= a)
    return a
  }
}