package datastructure.queue

class MyQueue<T>(
    private val mutableList: MutableList<T> = mutableListOf()
) {
    fun enqueue(item: T): Boolean {
        return mutableList.add(item)
    } fun dequeue(): T? {
        return if (mutableList.isNotEmpty()) mutableList.removeAt(0) else null
    }
    fun isEmpty(): Boolean = mutableList.isEmpty()
}

fun main() {
    val q: MyQueue<String> = MyQueue()
    q.enqueue("Hello1")
    q.enqueue("Hello2")
    q.enqueue("Hello3")
    println(q.dequeue())
    println(q.dequeue())
    println(q.dequeue())
}
