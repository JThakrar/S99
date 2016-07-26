/**
P02 (*) Find the last but one element of a listIn.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */

object P02 {
  def main(args: Array[String]): Unit = {
    println(penultimate(List(1, 1, 2, 3, 5, 8)))
  }

  def penultimate[T](l: List[T]): T = {
    l.init.last
  }
}
