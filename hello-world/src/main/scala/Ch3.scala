object Ex1 extends App {
    println(loop(5).mkString)

    def loop(n: Int): Array[Int] = (for (i <- 0.until(n)) yield i).toArray
}

object Ex1 extends App {
    println(loop(5).mkString)

    def loop(n: Int): Array[Int] = (for (i <- 0.until(n)) yield i).toArray
}