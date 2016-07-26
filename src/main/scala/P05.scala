/**
P05 (*) Reverse a listIn.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

object P05 {
  def main(args: Array[String]):Unit = {
    println(reverse(2, List(1, 1, 2, 3, 5, 8)))
  }

  def reverse[T](n:Int, l: List[T]): List[T] = {
    //l.reverse
    val maxIndex = l.length - 1
    val returnVal = for (i <- 0 to maxIndex) yield l(maxIndex - i)
    returnVal.toList
  }
}
