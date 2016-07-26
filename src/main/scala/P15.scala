/**
P15 (**) Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */

object P15 {
  def main(args: Array[String]): Unit = {
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  }

  private def listN[T](n:Int, t:T): List[T] = {
    val l = for (i <- 0 until n) yield t
    l.toList
  }

  def duplicateN[T](n:Int, list: List[T]): List[T] = {
    list match {
      case Nil => Nil
      case head::tail => listN(n, head) ++ duplicateN(n, tail)
    }
  }
}
