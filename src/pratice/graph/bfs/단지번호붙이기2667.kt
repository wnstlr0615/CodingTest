package pratice.graph.bfs

import java.util.*

private var N: Int = 0
private val dx = arrayOf(0, 1, 0, -1)
private val dy = arrayOf(1, 0, -1, 0)
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val blockSizeList = mutableListOf<Int>()
private var totalBlockSize = 0
fun main() {
    N = readln().toInt()
    arr = Array(N) { IntArray(N) }
    visited = Array(N) { BooleanArray(N) }

    for (i in 0 until N) {
        arr[i] = readln().toCharArray().map { it - '0' }.toIntArray()
    }
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (arr[i][j] == 1 && !visited[i][j]) {
                totalBlockSize++
                bfs(i, j)
            }
        }
    }
    blockSizeList.sort()
    println(totalBlockSize)
    blockSizeList.forEach { println(it) }
}

private fun bfs(startX: Int, startY: Int) {
    val needVisited = LinkedList<Int>()
    needVisited.add(startX)
    needVisited.add(startY)
    var blockSize = 0
    while (needVisited.isNotEmpty()) {
        val px = needVisited.poll()
        val py = needVisited.poll()
        if (visited[px][py]) {
            continue
        }
        visited[px][py] = true
        blockSize++
        for (i in 0 until 4) {
            val x = px + dx[i]
            val y = py + dy[i]
            if (x >= 0 && y >= 0 && x < N && y < N) {
                if (!visited[x][y] && arr[x][y] == 1) {
                    needVisited.add(x)
                    needVisited.add(y)
                }
            }
        }
    }
    blockSizeList.add(blockSize)
}
