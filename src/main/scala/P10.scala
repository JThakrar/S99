/**
P10 (*) Runlength
encoding of a list.
Use the result of problem P09 to implement the socalled
runlength
encoding data compression method. Consecutive duplicates of elements are encoded as tuples
(N, E) where N is the number of duplicates of the element E.
Example:
scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  */

object P10 {
  def main(args: Array[String]): Unit = {
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  private def consecutive[T](listIn: List[T], resultIn: List[List[T]]): (List[T], List[List[T]]) = {
    listIn match {
      case Nil => (Nil, resultIn)
      case head :: Nil => (Nil, resultIn :+ List(head))
      case _ => consecutive(listIn.dropWhile(listIn.head == _), resultIn :+ List(listIn.takeWhile(listIn.head == _): _*))
    }
  }

  private def pack[T](list: List[T]): List[List[T]] = {
    consecutive(list, Nil)._2
  }

  def encode[T](list: List[T]): List[Tuple2[Int, T]] = {
    pack(list).map(i => Tuple2(i.size, i.head))
  }
}
