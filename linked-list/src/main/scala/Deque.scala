case class Node[A](var prev: Option[Node[A]], var next: Option[Node[A]], get: A)

case class Deque[A](private var _head: Option[Node[A]], private var _tail: Option[Node[A]]) {
  def head = _head
  def tail = _tail

  def unshift(value: A): Unit = {
    val node = Some(Node(None, _head, value))

    _head match {
      case Some(n) => n.prev = node
      case None => ()
    }

    _tail match {
      case Some(_) => ()
      case None => _tail = node
    }

    _head = node
  }

  def shift: Option[A] = _head match {
    case None => None
    case Some(n) =>
      _head = n.next
      _head.map(nn => nn.prev = None)
      Some(n.get)
  }

  def push(value: A): Unit = {
    val node = Some(Node(_tail, None, value))
    _tail.map(nn => nn.next = node)
    _tail = node

    _head match {
      case None => _head = node
      case Some(_) => ()
    }
  }

  def pop: Option[A] = _tail match {
    case None => None
    case Some(n) =>
      _tail = n.prev
      _tail.map(nn => nn.next = None)
      Some(n.get)
  }
}

object Deque {
  def apply[A](): Deque[A] = Deque(None, None)
}
