/**
P03 (*) Find the Kth element of a listIn.
By convention, the first element in the listIn is element 0.
Example:
scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */

object P03 {
  def main(args: Array[String]):Unit = {
    println(nth(2, List(1, 1, 2, 3, 5, 8)))
  }

  def nth[T](n:Int, l: List[T]): T = {
    l(n)
  }
}
