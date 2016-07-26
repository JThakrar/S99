import scala.util.Random

/**
P23 (**) Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
Hint: Use the solution to problem P20
 */

object P23 {
  private val randomGenerator = new Random()

  def main(args: Array[String]): Unit = {
    println(randomSelect2(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelect2(13, List('a, 'b, 'c, 'd, 'f, 'g, 'h, 'i, 'j)))
    println(randomSelect2(-3, List('a, 'b, 'c, 'd, 'f, 'g, 'h, 'i, 'j)))
    println(randomSelect(100000, (1 to 9999999).toList).length)
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

  def randomInts(n: Int, start: Int, end: Int): List[Int] = {
    if (n <= 0 || start > end) {
      List[Int]()
    } else {
      val range = end - start + 1
      for (i <- (0 until n).toList) yield(randomGenerator.nextInt(range) + start)
    }
  }

  // This is the easy way :-)
  def randomSelect[T](n: Int, list: List[T]): List[T] = {
    val length = list.length
    if (n <= 0) {
      return List[T]()
    }
    if (n >= length) {
      list
    } else {
      scala.util.Random.shuffle(list).take(n)
    }
  }

  def randomSelect2[T](n: Int, list: List[T]): List[T] = {
    val length = list.length
    if (n <= 0) {
      return List[T]()
    }
    if (n >= length) {
      list
    } else {
      // Remember removeAt returns a tuple (List[T], T)
      val nextSelection = removeAt(randomGenerator.nextInt(list.length - 1), list)
      n match {
        case 1 => List(nextSelection._2)
        case _ => List(nextSelection._2) ++ randomSelect2(n - 1, nextSelection._1)
      }
    }
  }

}
