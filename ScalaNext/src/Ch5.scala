import scala.beans.BeanProperty

object Ch5_Ex1 extends App {

  class Counter(private var value:Int) {
    def increment() {
      if (value < Int.MaxValue)
        value += 1
    }
    def current = value
  }

  val counter = new Counter(Integer.MAX_VALUE);
  counter.current
  counter.increment()
  counter.current
  println(counter.current)
}

object Ch5_Ex2 extends App {

  class BankAccount(private var balance: Int) {
    def current = balance

    def deposit(value: Int) {
      balance += value
    }

    def withdraw(value: Int) {
      balance -= value
    }
  }

  val counter = new BankAccount(100);
  counter.deposit(10)
  counter.withdraw(2)
  println(counter.current)
}

object Ch5_Ex4 extends App {
  class Time2(val hours: Int, val minutes: Int) {
    private val minsSinceMidnight = hours * 60 + minutes
    def before(other: Time2) = minsSinceMidnight < other.minsSinceMidnight
  }

  println(new Time2(19, 31).before(new Time2(21, 30)))
  println(new Time2(19, 31).before(new Time2(19, 30)))
  println(new Time2(19, 31).before(new Time2(19, 31)))
  println(new Time2(19, 31).before(new Time2(19, 32)))
}

object Ch5_Ex5 extends App {
  class Student(@BeanProperty var id: Long,
                @BeanProperty var name: String) {
    override def toString = s"Student[$id:$name]"
  }
  val larry = new Student(1L, "Larry")
  larry.setName(larry.getName() + " Laffer")
  larry.id = larry.id + 1
  println(larry)
}