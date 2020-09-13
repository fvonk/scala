//import Ch6_Ex6.CardSuit
//import java.awt.Point

object Ch6_Ex1 extends App {
  object Conversions {
    def milesToKilometers(miles: Double) = miles * 1.61
  }

  println(Conversions.milesToKilometers(20))
}

object Ch6_Ex2 extends App {
  trait UnitConversions {
    def convert(value: Double): Double
  }

  object MilesToKilometers extends UnitConversions  {
    def convert(value: Double): Double = value * 1.61
  }

  println(MilesToKilometers.convert(20))
}

object Ch6_Ex3 extends App {
  object Origin extends java.awt.Point {

  }

  println(Origin.setLocation(1, 2))
}

object Ch6_Ex4 extends App {
  class Point private(var x: Double, var y: Double) {
    override def toString = { s"$x : $y" }
  }

  object Point {
    def apply(x: Double, y: Double) = new Point(x, y)
  }

  println(Point(1, 2).toString)
}

object Ch6_Ex5 extends App { println(args.reverse.mkString(" ")) }
//Ch6_Ex5.main(Array("Hello", "World!"))

object Ch6_Ex6 extends App {//7
  object CardSuit extends Enumeration {
    type CardSuit = Value
    val diamond = Value("♦")
    val club = Value("♣")
    val peak = Value("♠")
    val hearts = Value("♥")
  }

  def isRed(suit: CardSuit.CardSuit) = Array(CardSuit.diamond, CardSuit.hearts).contains(suit)

  println(CardSuit.values)
  println(isRed(CardSuit.diamond))
}

object Ch6_Ex8 extends App {//7
  object CubeColor extends Enumeration {
    type CubeColor = Value
    val Black   = Value(0x000000)
    val Red     = Value(0xff0000)
    val Green   = Value(0x00ff00)
    val Blue    = Value(0x0000ff)
    val Yellow  = Value(0xffff00)
    val Magenta = Value(0xff00ff)
    val Cyan    = Value(0x00ffff)
    val White   = Value(0xffffff)
  }

  println(CubeColor.values)
  for( c <- CubeColor.values ) println("0x%06x: %s".format(c.id, c))
}