/**
P08 (**) Eliminate consecutive duplicates of listIn elements.
If a listIn contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:
scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */

object P08 {
  def main(args: Array[String]): Unit = {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
  def compress[T](l: List[T]): List[T] = {
    l match {
      case Nil => List[T]()
      case head::tail => head::compress(tail.dropWhile(head == _))
    }
  }
}
