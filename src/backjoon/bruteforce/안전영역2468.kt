package backjoon.bruteforce

import java.util.*

private var N = 0
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private val q = LinkedList<Int>()

fun main(){
    N = readln().toInt()
    arr = Array(N){ IntArray(0) }
    var max = Int.MIN_VALUE
    visited = Array(N){ BooleanArray(N) }
    for(i in 0 until N){
        arr[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    for(i in arr.indices){
        arr[i].forEach {num ->
            if(num > max) max = num
        }
    }
    var maxCnt = Int.MIN_VALUE
    var cnt: Int

    for(h in 0 ..max){
        cnt = 0
        for(i in 0 until N){
            for(j in 0 until N){
                if(!visited[i][j] && arr[i][j] > h){
                    bfs(i, j, h)
                    cnt++
                }
            }
        }
        visited.forEach { Arrays.fill(it, false) }
        if(cnt > maxCnt){
            maxCnt = cnt
        }
    }
    println(maxCnt)
}

fun bfs(startX: Int, startY: Int, h: Int) {
    q.add(startX)
    q.add(startY)
    visited[startX][startY] = true
    while(q.isNotEmpty()){
        val px = q.poll()
        val py = q.poll()

        for(i in 0 until 4){
            val x = px + dx[i]
            val y = py + dy[i]
            if(x >= 0 && y >= 0 && x < N && y < N){
                if(!visited[x][y] && arr[x][y] > h){
                    q.add(x)
                    q.add(y)
                    visited[x][y] = true

                }
            }
        }

    }
}
