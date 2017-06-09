class Deque[A] {

  type TNode = Option[Node]

  sealed trait Node{
    var prev: TNode
    var next: TNode
  }

  case class EndNode(var prev: TNode, var next: TNode) extends Node
  case class ValueNode(var prev: TNode, value: A, var next: TNode) extends Node

  var end: TNode = Some(EndNode(None, None))
  end.foreach(en => {
    en.prev = end
    en.next = end
  })

  def unshift(value: A): Unit = {
    val node: TNode = Some(ValueNode(end, value, end.flatMap(en => en.next)))
    end.foreach(en => {
      en.next.foreach(fn => fn.prev = node)
      en.next = node
    })
  }

  def shift: Option[A] = {
    end.flatMap(en => en.next.flatMap(fn => fn match {
      case _: EndNode => None
      case fn: ValueNode =>
        en.next = fn.next
        fn.next.foreach(sn => sn.prev = end)
        Some(fn.value)
    }))
  }

  def push(value: A): Unit = {
    val node: TNode = Some(ValueNode(end.flatMap(en => en.prev), value, end))
    end.foreach(en => {
      en.prev.foreach(ln => ln.next = node)
      en.prev = node
    })
  }

  def pop: Option[A] = {
    end.flatMap(en => en.prev.flatMap(ln => ln match {
      case _: EndNode => None
      case ln: ValueNode =>
        en.prev = ln.prev
        ln.prev.foreach(sn => sn.next = end)
        Some(ln.value)
    }))
  }

  def print: String = {
    def loop(node: TNode): String = {
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
