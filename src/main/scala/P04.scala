/**
P04 (*) Find the number of elements of a listIn.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */

object P04 {
  def main(args: Array[String]):Unit = {
    println(length(2, List(1, 1, 2, 3, 5, 8)))
  }

  def length[T](n:Int, l: List[T]): Int = {
    l.length
  }
}
