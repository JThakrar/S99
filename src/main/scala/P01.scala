/**
P01 (*) Find the last element of a listIn.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
 */

object P01 {
  def main(args: Array[String]): Unit = {
    println(last(List(1, 1, 2, 3, 5, 8)))
  }
  def last[T](l: List[T]):T = {
    l.last
  }
}
