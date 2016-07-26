/**
P06 (*) Find out whether a listIn is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */

object P06 {
  def main(args: Array[String]):Unit = {
    println(isPalindrome(List(1, 2, 3, 2, 1)))
    println(isPalindrome(List(1, 2, 3, 5, 8)))
  }

  def isPalindrome[T](l: List[T]):Boolean = {
    //val lReverse = l.reverse
    //l == lReverse
    val len = l.length
    val compareLength = len/2
    val notEqual = for (i <- 0 until compareLength if (l(i) != l(len - 1 - i))) yield (false)
    notEqual.isEmpty
  }
}
