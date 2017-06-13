class Deque[A] {

  type NodeOp = Option[Node]

  sealed trait Node{
    var prev: NodeOp
    var next: NodeOp
  }

  case class EndNode(var prev: NodeOp, var next: NodeOp) extends Node
  case class ValueNode(var prev: NodeOp, value: A, var next: NodeOp) extends Node

  var end: NodeOp = Some(EndNode(None, None))
  end.foreach(en => {
    en.prev = end
    en.next = end
  })

  def head = end.flatMap(_.next)
  def head_= (node: NodeOp) = end.foreach(en => en.next = node)
  def tail = end.flatMap(_.prev)
  def tail_= (node: NodeOp) = end.foreach(en => en.prev = node)

  def unshift(value: A): Unit = {
    val node: NodeOp = Some(ValueNode(end, value, head))
    head.foreach(_.prev = node)
    head = node
  }

  def shift: Option[A] = {
    head.flatMap(_ match {
      case _: EndNode => None
      case hn: ValueNode =>
        head = hn.next
        hn.next.foreach(_.prev = end)
        Some(hn.value)
    })
  }

  def push(value: A): Unit = {
    val node: NodeOp = Some(ValueNode(tail, value, end))
    tail.foreach(_.next = node)
    tail = node
  }

  def pop: Option[A] = {
    tail.flatMap(_ match {
      case _: EndNode => None
      case tn: ValueNode =>
        tail = tn.prev
        tn.prev.foreach(_.next = end)
        Some(tn.value)
    })
  }

  // Debug method
  def print: String = {
    def loop(node: NodeOp): String = {
      node.map(n => n.next match {
        case Some(nn: ValueNode) => nn.value.toString + "," + loop(n.next)
        case _ => "end"
      }).get
    }
    loop(end)
  }
}

object Deque {
  def apply[A](): Deque[A] = new Deque[A]
}
