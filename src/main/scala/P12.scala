/**
P12 (**) Decode a runlength
encoded list.
Given a runlength
code list generated as specified in problem P10, construct its uncompressed version.
Example:
scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

object P12 {
  def main(args: Array[String]): Unit = {
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }

  private  def decode2[T](currentOutput: List[T], subList: List[Tuple2[Int, T]]): List[T] = {
    subList match {
      case Nil => currentOutput
      case head::tail => {
        val output = currentOutput ++ {
          for (i <- 0 until head._1) yield head._2
        }
        decode2(output, tail)
      }
    }
  }

  def decode[T](list: List[Tuple2[Int, T]]): List[T] = {
    decode2(Nil, list)
  }
}
