import scala.io
import scala.io.StdIn

object Main extends App {
  print(f"${if (2 > 1) ()}")
  println("Hello, World!")

  box("Hello")

  println("done")

  def box(s: String) {
    val border = "-" * (s.length + 2)
    print(f"$border%n|$s|%n$border%n")
  }

  println(f"signum, ${signum(-22)}")

  def signum(x: Int) = {
    if (x > 0) 1
      else if (x == 0) 0
      else -1
  }

  assert( signum(4) == 1 )
}