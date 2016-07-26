import scala.util.Random

/**
P24 (*) Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
  */

object P24 {
  private val randomGenerator = new Random()

  def main(args: Array[String]): Unit = {
    println(lotto(6,49))
    println(lotto(3, 30))
    println(lotto(33, 30))
    println(lotto(-3, 30))
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

  def lotto(n: Int, m: Int): List[Int] = {
    if (n <= 0) {
      return List[Int]()
    }
    val list = Range(1, m+1).toList
    val length = list.length
    if (n >= length) {
      list
    } else {
      randomSelect(n, list)
    }
  }

}
