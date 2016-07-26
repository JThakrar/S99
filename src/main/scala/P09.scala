/**
P09 (**) Pack consecutive duplicates of listIn elements into sublists.
If a listIn contains repeated elements they should be placed in separate sublists.
Example:
scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

object P09 {
  def main(args: Array[String]): Unit = {
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(pack((1 until 10000).toList))
  }

  def consecutive[T](listIn: List[T], resultIn: List[List[T]]): (List[T], List[List[T]]) = {
    listIn match {
      case Nil => (Nil, resultIn)
      case head::Nil => (Nil, resultIn :+ List(head))
      case _ => consecutive(listIn.dropWhile(listIn.head == _), resultIn :+ List(listIn.takeWhile(listIn.head == _):_*))
    }
  }

  def pack[T](list: List[T]): List[List[T]] = {
    consecutive(list, Nil)._2
  }
}
