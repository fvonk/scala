import scala.io.StdIn
import scala.math
import java.time.LocalDate

object Start {

  def main(args: Array[String]): Unit = {
    lesson1()
  }

  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      
    }
  }

  /* just comment */
  /** Documentation */
  def lesson1() {
    println(s"power ${power(2, 2)}")

//    var res: Long = 1
//    for (i <- "Hello") {
//      println(i.toLong)
//      res *= i
//    }
//    println(s"res is $res")
//    println("Hello".foldLeft(1L)(_ * _.toInt))
//    println(product("Hello"))
//    println(productReq("Hello"))

//    val name = "Pavel"
//    println(f"---%n$name")
//    println("opa")
//    println(signum(23), signum(-2), signum(0))
//    println({}.isInstanceOf[Unit])
//    println({}.getClass)

//    var x: Unit = {}
//    println(f"x is $x ${x.getClass}")
//    var y: Int = 0
//    x = y = 1
//    println(x, y)

//    countdown(7)
  }

  def power(x: BigDecimal, n: Int): BigDecimal = {
    print(x, n)
    if (n > 0) {
      if (n % 2 == 0) {
        power(power(x, n / 2), 2)
      } else {
        x * power(x, n - 1)
      }
    } else if (n == 0) 1
    else {
      1 / power(x, -n)
    }
  }

  def product(s: String): Long = {
    s.foldLeft(1L)(_ * _.toInt)
  }

  def productReq(s: String): Long = {
    if (s.length > 0) s.head.toLong * productReq(s.tail) else 1L
  }

  /*procedure*/
  def countdown(n: Int) {
    for (i <- (0.to(n)).reverse) {
      println(i)
    }
  }

  def signum(value: Int) = {
    if (value > 0) 1
    else if (value < 0) -1
    else 0
  }
}
