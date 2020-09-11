import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.JavaConverters
import scala.collection.mutable.{ArrayBuffer, Buffer}

object Ex2 extends App {

  var arr = Array(1, 2, 3, 4)
  val max = if (arr.length % 2 == 0) arr.length else (arr.length - 1)
  for (i <- 0.until(max - 1)) {
    val temp = arr(i)
    arr(i) = arr(i + 1)
    arr(i + 1) = temp
  }
  println(arr.mkString)
  def swat(arr: Array[Int]): Unit = {

  }
}


object Ex3 extends App {

  var arr = Array(1, 2, 3, 4)
  println(swap(arr).mkString)

  def swap(arr: Array[Int]): Array[Int] = {
    (for {i <- arr.grouped(2); j <- i.reverse} yield j).toArray
  }
}

object Ex4 extends App {

  var arr = Array(1, -3, -34, 2, 0, 3, 4, 0, -12, -9, -2)
  println(order(arr).mkString(", "))

  def order(arr: Array[Int]): Array[Int] = {
//    arr.filter(_ > 0) ++ arr.filter(_ < 0) ++ arr.filter(_ == 0)
    val (x, y) = arr.partition(_ > 0)
    x ++ y
//    val posIndexes = for (i <- arr.indices if arr(i) > 0)  yield i
//    val negIndexes = for (i <- arr.indices if arr(i) < 0)  yield i
//    val zeroIndexes = for (i <- arr.indices if arr(i) == 0)  yield i
//
//    val newArr = ArrayBuffer[Int]()
//    posIndexes.foreach { arg => newArr.append(arr(arg)) }
//    negIndexes.foreach { arg => newArr.append(arr(arg)) }
//    zeroIndexes.foreach { arg => newArr.append(arr(arg)) }
//    newArr.toArray
  }
}

object Ex5 extends App {
  def avg(a: Array[Double]) = a.sum / a.length

  println(avg(Array(1, 2.3, 4, 6)))
}

object Ex7 extends App {
  def removeFirstNegative(a: ArrayBuffer[Int]) = {
    (a.indices.filter(a(_) < 0) drop 1).reverse.foreach(a.remove(_))
  }
  val a = ArrayBuffer(1, -2, -5, -66, 2, 2, 3, -1, 0, 12)
  removeFirstNegative(a)
  println(a.mkString(", "))
}

import java.util.TimeZone.getAvailableIDs

object Ex9 extends App {
  getAvailableIDs
    .filter(_.startsWith("America/"))
    .map(_.stripPrefix("America/"))
    .sorted
    .map(println)

}

object Ex10 extends App {
  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  val flavorBuffer: Buffer[String] = JavaConverters.asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala
  println(flavorBuffer)
}