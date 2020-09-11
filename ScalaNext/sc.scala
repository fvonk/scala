import scala.beans.BeanProperty 

class Student(@BeanProperty var id: Long,
                @BeanProperty var name: String) {
    override def toString = s"Student[$id:$name]"
  }
