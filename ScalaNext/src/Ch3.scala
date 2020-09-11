import java.util.{Calendar, Scanner}

import scala.io.Source._
import java.io.File
import java.util

import scala.collection.JavaConverters._
import scala.jdk.CollectionConverters
import java.util.Calendar._

object Ch4Ex8 extends App {
  def minmax(values: Array[Int]) = (values.min, values.max)
//  println(minmax(Array(12, 34, 45, 34, -34, 0)))

  def lteqgt(values: Array[Int], v: Int) = {
    (
      values.count(_ < v),
      values.count(_ == v),
      values.count(_ > v)
    )
  }
  println(lteqgt(Array(12, 34, 45, 34, -34, 0), v = 34))

  println("Hello".zip("World"))
  println(for ((i, j) <- "Hello".zip("World)")) yield i == j)
}

object Ch4Ex7 extends App {
  val properties: scala.collection.Map[String, String] = System.getProperties.asScala
  val maxKeyLength = properties.keys.map(_.length).max
  properties.foreach { pair => println(f"${pair._1}${" " * (maxKeyLength - pair._1.length)} | ${pair._2}") }
}

object Ch4Ex6 extends App {
  val linked = scala.collection.mutable.LinkedHashMap(
    "Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Thursday" -> java.util.Calendar.THURSDAY
  )
  linked.foreach(println)
}

object Ex1 extends App {
  val things: Map[String, Double] = Map("one" -> 1, "two" -> 2, "three" -> 3.3)
//  val thingsUp = things.keySet.zip(things.values.map( arg => arg * 0.9)).toMap
//  val thingsUp = for ((k, v) <- things) yield (k, v * 0.9)
  val thingsUp = things.view.mapValues(_ * 0.9).toMap
  println(thingsUp)
}

object Ch4_Ex2 extends App {
  println(System.getProperties.getProperty("user.dir"))

  val file = new File("src/DateInterpolator.txt")
  def iterateWordsInFile(f: File): Iterator[String] =
    new Scanner(f).asScala

//  val words = scala.collection.mutable.Map[String, Int]().withDefaultValue(0)
//  for (w <- iterateWordsInFile(file)) {
//    words(w) += 1
//  }

//  var words = scala.collection.immutable.Map[String, Int]()
//    for (w <- iterateWordsInFile(file))
//      words = words + (w -> (words.getOrElse(w, 0) + 1))

//  var words = scala.collection.immutable.SortedMap[String, Int]()
//  for (w <- iterateWordsInFile(file))
//    words = words + (w -> (words.getOrElse(w, 0) + 1))

  var words: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]().asScala
  for (w <- iterateWordsInFile(file))
    words = words + (w -> (words.getOrElse(w, 0) + 1))

  words.foreach(println)

}