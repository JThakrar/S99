/**
P21 (*) Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */

object P21 {
  def main(args: Array[String]): Unit = {
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
    println(insertAt('new, -1, List('a, 'b, 'c, 'd)))
    println(insertAt('new, 5, List('a, 'b, 'c, 'd)))
    println(insertAt('new, 3, List('a, 'b, 'c, 'd)))
  }

  def insertAt[T](t:T, n: Int, list: List[T]): List[T] = {
    val length = list.length
    if (n >= length || n < 0) {
      list
    } else {
      list.slice(0,n) ++ List(t) ++ list.slice(n, length)
    }
  }
}
