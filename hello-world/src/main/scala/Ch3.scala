object Ex1 extends App {
    println(loop(5).mkString)

    def loop(n: Int): Array[Int] = (for (i <- 0.until(n)) yield i).toArray
}

// object Ex2 extends App {
//     println(flip(Array(1, 2, 3, 4, 5)))

//     def flip(arr: Array[Int]): Array[Int] = {
//         val end = arr.length % 2 == 0 ? arr.length : arr.length - 1
//         for (i <- 0.to(end)) {
//             // arr(i) 
//         }
//         arr
//     }
// }