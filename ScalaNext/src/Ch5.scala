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
  larry.id_=(22)
  larry.id += 1
  println(larry)
}

object Ch5_Ex6 extends App {
  class Person(a: Int) {
    var age = Math.max(a, 0)
  }

  val paul = new Person(-2)
  assert(paul.age == 0)
  println(paul.age)
}

object Ch5_Ex7 extends App {

  class Person(fullName: String) {
    val firstName = fullName.split(" ")(0)
    val lastName = fullName.split(" ")(1)
  }

  val person = new Person("Mister Smith")
  println(person.firstName, person.lastName)
}

object Ch5_Ex8 extends App {
  class Car(val manufacturer: String,
            val modelName: String,
            val modelYear: Int,
            var licensePlate: String) {

    def this(manufacturer: String, modelName: String) {
      this(manufacturer, modelName, -1, "")
    }
    def this(manufacturer: String, modelName: String, modelYear: Int) {
      this(manufacturer, modelName, modelYear, "")
    }
    def this(manufacturer: String, modelName: String, licensePlate: String) {
      this(manufacturer, modelName, -1, licensePlate)
    }
    override def toString() = s"Car[$manufacturer, $modelName, $modelYear, $licensePlate)"
  }
  val car = new Car("Honda", "Civic")
  println(car)
  new Car("Honda", "Civic", "ZL-GJ-37")
  new Car("Honda", "Civic", 2008, "ZL-GJ-37")
}

object Ch5_Ex10 extends App {
  class Employee(val name: String = "John", var salary: Double = 0.0) {
    override def toString: String = s"Employee $name, $salary"
  }

  val employee = new Employee()
  println(employee)
}