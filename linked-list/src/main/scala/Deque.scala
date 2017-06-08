class Deque[A] {
  abstract class Node[AA] {
    var prev: Node[AA]
    var next: Node[AA]
  }

  case class EndNode(var prev: Node[A], var next: Node[A]) extends Node[A]
  case class ValueNode(var prev: Node[A], get: A, var next: Node[A]) extends Node[A]

  val end: EndNode = EndNode(null, null)
  end.prev = end
  end.next = end

  def unshift(value: A): Deque[A] = {
    val node = ValueNode(end, value, end.next)
    end.next.prev = node
    end.next = node
    this
  }

  def shift: Option[A] = {
    end.next match {
      case EndNode(_, _) => None
      case ValueNode(p, v, n) =>
        end.next.prev = n
        end.next = n
        Some(v)
    }
  }

  def push(value: A): Deque[A] = {
    val node = ValueNode(end.prev, value, end)
    end.prev.next = node
    end.prev = node
    this
  }

  def pop: Option[A] = {
    end.prev match {
      case EndNode(_, _) => None
      case ValueNode(p, v, n) =>
        end.prev.next = p
        end.prev = p
        Some(v)
    }
  }
}

object Deque {
  def apply[A](): Deque[A] = new Deque[A]
}