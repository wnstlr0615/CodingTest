package pratice.graph.bfs

import java.util.LinkedList
private val move = arrayOf(
    arrayOf(2, 1),
    arrayOf(1, 2),
    arrayOf(-1, 2),
    arrayOf(-2, 1),
    arrayOf(-2, -1),
    arrayOf(-1, -2),
    arrayOf(1, -2),
    arrayOf(2, -1),
)

fun main(){
    val T = readln().toInt()
    repeat(T){
        val l = readln().toInt()
        val (startX, startY) = readln().split(" ").map { it.toInt() }
        val (endX, endY) = readln().split(" ").map { it.toInt() }
        val cnt = bfs(l, startX, startY, endX, endY)
        println(cnt)

    }

}
fun bfs(
    l: Int,
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int
): Int {
    val needVisited = LinkedList<Int>()
    val distances = Array(l) { IntArray(l) }
    needVisited.add(startX)
    needVisited.add(startY)

    while (needVisited.isNotEmpty()) {
        val px = needVisited.poll()
        val py = needVisited.poll()

        if (px == endX && py == endY) {
            break
        }

        for ((dx, dy) in move) {
            val x = px + dx
            val y = py + dy

            if (x >= 0 && y >= 0 && x < l && y < l) {
                if (distances[x][y] == 0 || distances[x][y] > distances[px][py] + 1) {
                    needVisited.add(x)
                    needVisited.add(y)
                    distances[x][y] = distances[px][py] + 1
                }
            }
        }
    }
    return distances[endX][endY]
}