package alogorizm.bfs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

private fun dijkstra(graph: java.util.HashMap<String, ArrayList<Edge>>, startNode: String): MutableMap<String, Int> {
    val distances = mutableMapOf<String, Int>()
    for (key in graph.keys) {
        distances[key] = Int.MAX_VALUE
    }
    distances[startNode] = 0
    val pq = PriorityQueue<Edge>()
    pq.add(Edge(startNode, 0))

    while (pq.isNotEmpty()) {
        val edgeNode = pq.poll()
        if (distances[edgeNode.node]!! < edgeNode.distance) {
            continue
        }

        for (edge in graph[edgeNode.node]!!) {
            if (distances[edge.node]!! > distances[edgeNode.node]!! + edge.distance) {
                val distance = distances[edgeNode.node]!! + edge.distance
                distances[edge.node] = distance
                pq.add(Edge(edge.node, distance))
            }
        }
    }
    return distances
}

fun main() {
    val graph = HashMap<String, ArrayList<Edge>>()
    graph["A"] =
        ArrayList(listOf(Edge("B", 8), Edge("C", 1), Edge("D", 2)))
    graph["B"] = ArrayList()
    graph["C"] = ArrayList(listOf(Edge("B", 5), Edge("D", 2)))
    graph["D"] = ArrayList(listOf(Edge("E", 3), Edge("F", 5)))
    graph["E"] = ArrayList(listOf(Edge("F", 1)))
    graph["F"] = ArrayList(listOf(Edge("A", 5)))

    val result = dijkstra(graph, "A")
    println(result)
}

private class Edge(
    val node: String,
    val distance: Int
) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return distance - other.distance
    }
}
