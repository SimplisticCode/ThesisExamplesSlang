// #Sireum

import org.sireum._

object DutchNationalFlag {

  def swap(input: MSZ[Z], i: Z, j: Z): MSZ[Z] = {
    Contract(
      Requires(i < input.length, j < input.length, i != j),
      Ensures(Res[MSZ[Z]].length == input.length,
        All(Res[MSZ[Z]].indices)(index => (index != i && index != j).imply_:(Res[MSZ[Z]](index) == input(index)))
      )
    )
    var result: MSZ[Z] = input
    val temp = input(i).t1
    result(i) = input(j).t1
    result(j) = temp
    return result
  }

  def dutchNationalFlagAlgorithm(input: ISZ[Z]): ISZ[Z] = {
    Contract(
      Requires(All(input)(e => (e == Z(0)) | (e == Z(1)) | (e == Z(2)))),
      Ensures(All(Res[ISZ[Z]].indices)(i => All(Res[ISZ[Z]].indices)(j => (i < j).imply_:(Res[ISZ[Z]](i) <= Res[ISZ[Z]](j))))
      )
    )
    //initialize all variables
    var reader: Z = 0
    var low: Z = 0
    var high: Z = input.length - 1
    var result: MSZ[Z] = input.toMS
    while (reader <= high) {
      if (result(reader).t1 == Z(0)) {
        result = swap(result, reader, low)
        reader += 1
        low += 1
      }
      else if (result(reader).t1 == Z(1)) {
        reader += 1
      }
      else if (result(reader).t1 == Z(2)) {
        result = swap(result, reader, high)
        high -= 1
      }
      else {
        halt("Bad input")
      }
    }

    return result.toIS
  }
}