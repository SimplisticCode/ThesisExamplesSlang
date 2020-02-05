// #Sireum

import org.sireum._

//Example from https://rise4fun.com/Dafny/74s9
//Presented in http://leino.science/papers/krml248.pdf
/*
module A {
  method Max(x: int, y: int) returns (m: int)
  ensures x <= m && y <= m
    decreases *
      {
        if x == y {
          m := x;
        } else if x < y {
          m := Max(y, x);
        } else {
          m := Max(x-1, y);
          m := m + 1;
        }
      }
}
module B refines A {
  method Max...
  ensures m == y || m == x
    decreases x < y, x - y
  method Main()
  {
    var m := Max(10, 20);
    assert m == 20;
  }
}
*/

//Can we introduce decrease in Slang? Will it be done and can we use it in the same way as we can in Dafny?
//This needs to be verified by Logika
@record trait A_module {
  def Max(x: Z, y: Z): Z = {
    Contract(
      Ensures(x <= Res && y <= Res)
    )
    var m: Z = 0
    if (x == y) {
      m = x
    } else if (x < y) {
      m = Max(y, x)
    } else {
      m = Max(x - 1, y)
      m = m + 1
    }
    return m
  }
}

@record class B_module extends A_module {
  override def Max(x: Z, y: Z): Z = {
    Contract(
      Ensures(Res == y || Res == x)
    )
    super.Max(x, y) //This is implicit in dafny
  }
}
