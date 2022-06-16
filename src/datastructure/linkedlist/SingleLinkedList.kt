package datastructure.linkedlist

class SingleLinkedList<T> (
    private var head: Node<T>? = null
) {
    fun addNode(data: T) {
        if (head == null) {
            head = Node(data)
        } else {
            var node: Node<T>? = head
            while (node?.next != null) {
                node = node.next
            }
            node?.next = Node(data)
        }
    }
    fun search(data: T): Node<T>? {
        if (head == null) {
            return null
        } else {
            var node: Node<T>? = head
            while (node != null) {
                if (node.data == data) {
                    return node
                }
                node = node.next
            }
            return null
        }
    }
    fun delNode(data: T): Boolean {
        if (head == null) {
            return false
        }
        var node: Node<T>? = head
        if (node!!.data == data) {
            head = node.next
            return true
        }
        while (node != null) {
            if (node.data == data) {
                node.next = node.next?.next
                return true
            }
            node = node.next
        }
        return false
    }
    fun printAll() {
        if (head != null) {
            println(head!!.data)
            var node: Node<T>? = head
            while (node?.next != null) {
                println(node.next?.data)
                node = node.next
            }
        }
    }
}

data class Node<T>(
    val data: T
) {
    var next: Node<T>? = null
}

fun main() {
    val list = SingleLinkedList<String>()
    list.addNode("hello")
    list.addNode("hi")
    list.addNode("joon")
    list.addNode("안녕")
    list.printAll()
    println(list.search("joon"))
    list.delNode("hi")
    list.printAll()
}
