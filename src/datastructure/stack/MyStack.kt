package datastructure.stack

class MyStack<T>(
    private val list: MutableList<T> = mutableListOf()
) {
    fun push(item: T): Boolean {
        return list.add(item)
    }
    fun pop(): T? {
        return if (list.isNotEmpty()) list.removeAt(list.size - 1) else null
    }
}

fun main() {
    val stack: MyStack<Int> = MyStack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}
