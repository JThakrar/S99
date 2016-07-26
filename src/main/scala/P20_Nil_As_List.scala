/**
P20_Nil_As_List (*) Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:
scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */

object P20_Nil_As_List {
  def main(args: Array[String]): Unit = {
    println(removeAt(1, List('a, 'b, 'c, 'd)))
    println(removeAt(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
    println(removeAt(9, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
    println(removeAt(19, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
    println(removeAt(-9, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
  }

  def removeAt[T](n: Int, list: List[T]): (List[T], T) = {
    val length = list.length
    if (n >= length || n < 0) {
      (list, Nil.asInstanceOf[T])
    } else {
      val ret = list.splitAt(n)
      (ret._1 ++ ret._2.tail, ret._2(0))
    }
  }

}
