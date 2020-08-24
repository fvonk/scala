import java.time.LocalDate

object Obj2 extends App {
  println("text")
}

object Obj3 extends App {
  val t = {}
  println("t", t)
//   assert(t == (), "is ()")
  assert(t.isInstanceOf[Unit])
}

object Ex3 extends App {
  var y = 3
  val x: Unit = y = 2
  assert(x.isInstanceOf[Unit])
  println(x, y)
}

object Ex4 extends App {
  for (i <- 0.to(10).reverse)
    println(i)

  10.to(0, -1).foreach(println)
}

object Ex5 extends App {
  countdown(44)

  def countdown(n: Int) {
    n.to(0, -1).foreach(println)
  }
}

object Ex65 extends App {
  println(calc("Hello"))
  println(calc2("Hello").isInstanceOf[Long])
  println(calc3("Hello"))

  def calc(s: String) = {
    var result: Long = 1
    for (i <- s) result *= i.toLong
    result
  }

  def calc2(s: String) = {
    s.map(_.toLong).product
  }

  def calc3(s: String): Long = {
    if (s.isEmpty()) 1 else s.head.toLong * calc3(s.tail)
  }

}

object Ex10 extends App {
//   println(LocalDate.of(2001, 2, 13))

  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if (args.size != 3) throw new Exception("3 arguments required")
      def values = args.map(_.toString.toInt)
      LocalDate.of(values(0), values(1), values(2))
    }
  }

  val year = 2018
  val month = 4
  val day = 24
  println(year)
  val t1 = date"$year-$month-$day"
  println(t1)
  val t2 = date"${1}-${2}-${3}"
  println(t2)
//   date"${1}-${2}" // -> Exception
}
