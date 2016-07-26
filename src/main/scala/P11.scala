/**
P11 (*) Modified runlength
encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are
transferred as (N, E) terms.
Example:
scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */

object P11 {
  def main(args: Array[String]): Unit = {
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
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

  def encodeModified[T](list: List[T]): List[Any] = {
    pack(list).map(i => if (i.size == 1) i.head else Tuple2(i.size, i.head))
  }
}
