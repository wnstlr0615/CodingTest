package pratice.graph.bfs

import java.util.*

fun main() {
    val (N, M, V) = readln().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Int>>(N + 1) { mutableListOf() }

    for (i in 0 until M) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        graph[start].add(end)
        graph[end].add(start)
    }
    dfs(graph, V)
    println()
    bfs(graph, V)
}

private fun dfs(graph: Array<MutableList<Int>>, start: Int) {
    val needVisited = Stack<Int>()
    val visited = mutableListOf<Int>()
    needVisited.add(start)
    while (needVisited.isNotEmpty()) {
        val node = needVisited.pop()
        if (!visited.contains(node)) {
            visited.add(node)
            needVisited.addAll(graph[node].sorted().reversed())
        }
    }
    visited.forEach { print("$it ") }
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int) {
    val needVisited = LinkedList<Int>()
    val visited = mutableListOf<Int>()
    needVisited.add(start)
    while (needVisited.isNotEmpty()) {
        val node = needVisited.poll()
        if (!visited.contains(node)) {
            visited.add(node)
            needVisited.addAll(graph[node].sorted())
        }
    }
    visited.forEach { print("$it ") }
}
