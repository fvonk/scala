import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.util.TimeZone.getAvailableIDs
import java.awt.datatransfer._

import scala.collection.JavaConverters
import scala.collection.mutable.Buffer
import scala.jdk.CollectionConverters
//import scala.collection.JavaConverters

class Lesson2 {

  def training(): Unit = {
    //1
    {
      val n = 8
      //    val array = new Array[Int](n)
      //    for (i <- 0 until n) array(i) = i
      val array = for (i <- 0 until n) yield Random.nextInt(n)
      //    println(array.foreach(print))
    }

    //2
    {
//      a.grouped(2).flatMap(_.reverse).toArray
    }

    //3
    {
      adjacent(Array(1, 2, 3, 4, 5)).foreach(println)
    }

    //4
    {
      val a = Array(1, -4, 2, 0, 7, -5, 0, 8, -9)
      val (x, y) = a.partition(_ > 0)
//      println((x ++ y).mkString(", "))

//      val newA = a.filter(_ > 0) ++ a.filter(_ <= 0)
//      println(newA.mkString(","))
    }

    //5
    {
      val a = Array(1.0, 2.0, 3.5)
//      print(a.sum / a.length)
    }

    //6
    {
      val a = Array(1, -4, 2, 0, 7, -5, 0, -8, -1)
//      println(a.distinct.mkString(", "))
    }

    //7
    {
      val a = ArrayBuffer(1, -4, 2, 0, 7, -5, 0, -8, -1)
      val negativeIndices = for (i <- a.indices if a(i) < 0) yield i
//      println(negativeIndices.reverse)
      for (i <- negativeIndices.drop(1).reverse) a.remove(i)
//      println(a.toString)
    }

    //10
    {
      val res = getAvailableIDs
        .filter(_.startsWith("America/"))
        .map(_.stripPrefix("America/"))
        .sorted
      println(res.mkString(", "))
    }

    //1
    {
      val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
      val flavorBuffer: Buffer[String] = JavaConverters.asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala
      println(flavorBuffer)
    }
  }

  def adjacent(a: Array[Int]): Array[Int] = {
    (for {i <- a.grouped(2); j <- i.reverse} yield j).toArray
  }

}