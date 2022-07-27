package pratice.graph.bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var br = BufferedReader(InputStreamReader(System.`in`))
private var H = 0
private var N = 0
private var M = 0
private lateinit var box: Array<Array<IntArray>>
private lateinit var distances: Array<Array<IntArray>>
private var dir = arrayOf(
    intArrayOf(0, 1, 0),
    intArrayOf(0, -1, 0),
    intArrayOf(0, 0, 1),
    intArrayOf(0, 0, -1),
    intArrayOf(1, 0, 0),
    intArrayOf(-1, 0, 0)
)
private var needVisited: Queue<Point> = LinkedList()
fun main(args: Array<String>) {
    input()
    pro()
}

private fun pro() {
    while (!needVisited.isEmpty()) {
        val p = needVisited.poll()
        for (i in 0..5) {
            val x = p.x + dir[i][0]
            val y = p.y + dir[i][1]
            val z = p.z + dir[i][2]
            if (x >= 0 && y >= 0 && x < H && y < N && z >= 0 && z < M) {
                if (distances[x][y][z] == 0 && box[x][y][z] == 0) {
                    needVisited.add(Point(x, y, z))
                    distances[x][y][z] = distances[p.x][p.y][p.z] + 1
                    box[x][y][z] = 1
                }
            }
        }
    }
    println(`fun`())
}

private fun `fun`(): Int {
    var max = -1
    for (i in 0 until H) {
        for (j in 0 until N) {
            for (k in 0 until M) {
                if (box[i][j][k] == 0) {
                    return -1
                }
                max = Math.max(distances[i][j][k], max)
            }
        }
    }
    return max
}

private fun input() {
    var split = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }
        .toTypedArray()
    M = split[0].toInt()
    N = split[1].toInt()
    H = split[2].toInt()
    box = Array(H) {
        Array(N) {
            IntArray(
                M
            )
        }
    }
    distances = Array(H) {
        Array(N) {
            IntArray(
                M
            )
        }
    }
    for (i in 0 until H) {
        for (j in 0 until N) {
            split = br.readLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (k in 0 until M) {
                box[i][j][k] = split[k].toInt()
                if (box[i][j][k] == 1) {
                    needVisited.add(Point(i, j, k))
                }
            }
        }
    }
}

private class Point(var x: Int, var y: Int, var z: Int)
