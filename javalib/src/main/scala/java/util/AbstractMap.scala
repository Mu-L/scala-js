/*
 * Scala.js (https://www.scala-js.org/)
 *
 * Copyright EPFL.
 *
 * Licensed under Apache License 2.0
 * (https://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package java.util

import scala.annotation.tailrec

import ScalaOps._

object AbstractMap {

  private def entryEquals[K, V](entry: Map.Entry[K, V], other: Any): Boolean = {
    other match {
      case other: Map.Entry[_, _] =>
        Objects.equals(entry.getKey(), other.getKey()) &&
        Objects.equals(entry.getValue(), other.getValue())
      case _ => false
    }
  }

  private def entryHashCode[K, V](entry: Map.Entry[K, V]): Int =
    Objects.hashCode(entry.getKey()) ^ Objects.hashCode(entry.getValue())

  class SimpleEntry[K, V](private var key: K, private var value: V)
      extends Map.Entry[K, V] with Serializable {

    def this(entry: Map.Entry[_ <: K, _ <: V]) =
      this(entry.getKey(), entry.getValue())

    def getKey(): K = key

    def getValue(): V = value

    def setValue(value: V): V = {
      val oldValue = this.value
      this.value = value
      oldValue
    }

    override def equals(o: Any): Boolean =
      entryEquals(this, o)

    override def hashCode(): Int =
      entryHashCode(this)

    override def toString(): String =
      "" + getKey() + "=" + getValue()
  }

  class SimpleImmutableEntry[K, V](key: K, value: V)
      extends Map.Entry[K, V] with Serializable {

    def this(entry: Map.Entry[_ <: K, _ <: V]) =
      this(entry.getKey(), entry.getValue())

    def getKey(): K = key

    def getValue(): V = value

    def setValue(value: V): V =
      throw new UnsupportedOperationException()

    override def equals(o: Any): Boolean =
      entryEquals(this, o)

    override def hashCode(): Int =
      entryHashCode(this)

    override def toString(): String =
      "" + getKey() + "=" + getValue()
  }
}

abstract class AbstractMap[K, V] protected () extends java.util.Map[K, V] {
  self =>

  def size(): Int = entrySet().size()

  def isEmpty(): Boolean = size() == 0

  def containsValue(value: Any): Boolean =
    entrySet().scalaOps.exists(entry => Objects.equals(value, entry.getValue()))

  def containsKey(key: Any): Boolean =
    entrySet().scalaOps.exists(entry => Objects.equals(key, entry.getKey()))

  def get(key: Any): V = {
    entrySet().scalaOps.findFold(entry => Objects.equals(key, entry.getKey())) { () =>
      null.asInstanceOf[V]
    } { entry =>
      entry.getValue()
    }
  }

  def put(key: K, value: V): V =
    throw new UnsupportedOperationException()

  def remove(key: Any): V = {
    @tailrec
    def findAndRemove(iter: Iterator[Map.Entry[K, V]]): V = {
      if (iter.hasNext()) {
        val item = iter.next()
        if (Objects.equals(key, item.getKey())) {
          iter.remove()
          item.getValue()
        } else
          findAndRemove(iter)
      } else
        null.asInstanceOf[V]
    }
    findAndRemove(entrySet().iterator())
  }

  def putAll(m: Map[_ <: K, _ <: V]): Unit =
    m.entrySet().scalaOps.foreach(e => put(e.getKey(), e.getValue()))

  def clear(): Unit =
    entrySet().clear()

  def keySet(): Set[K] = {
    new AbstractSet[K] {
      override def size(): Int = self.size()

      def iterator(): Iterator[K] = {
        new Iterator[K] {
          val iter = entrySet().iterator()

          def hasNext(): Boolean = iter.hasNext()

          def next(): K = iter.next().getKey()

          override def remove(): Unit = iter.remove()
        }
      }
    }
  }

  def values(): Collection[V] = {
    new AbstractCollection[V] {
      override def size(): Int = self.size()

      def iterator(): Iterator[V] = {
        new Iterator[V] {
          val iter = entrySet().iterator()

          def hasNext(): Boolean = iter.hasNext()

          def next(): V = iter.next().getValue()

          override def remove(): Unit = iter.remove()
        }
      }
    }
  }

  def entrySet(): Set[Map.Entry[K, V]]

  override def equals(o: Any): Boolean = {
    if (o.asInstanceOf[AnyRef] eq this) true
    else {
      o match {
        case m: Map[_, _] =>
          self.size() == m.size() &&
          entrySet().scalaOps.forall(item => Objects.equals(m.get(item.getKey()), item.getValue()))
        case _ => false
      }
    }
  }

  override def hashCode(): Int =
    entrySet().scalaOps.foldLeft(0)((prev, item) => item.hashCode + prev)

  override def toString(): String = {
    var result = "{"
    var first = true
    val iter = entrySet().iterator()
    while (iter.hasNext()) {
      val entry = iter.next()
      if (first)
        first = false
      else
        result += ", "
      result = result + entry.getKey() + "=" + entry.getValue()
    }
    result + "}"
  }
}
