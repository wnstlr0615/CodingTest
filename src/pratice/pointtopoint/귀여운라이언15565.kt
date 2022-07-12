package pratice.pointtopoint

import kotlin.math.min

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toList()
    var R = 0
    var cnt = 0
    var result = Int.MAX_VALUE
    for (L in 0 until N) {
        while (R < N && L <= R && cnt < K) {
            if (arr[R] == 1) {
                cnt++
            }
            R++
        }
        if (cnt == K) {
            result = min(result, R - L)
        }

        if (arr[L] == 1) {
            cnt--
        }
    }
    println(if (result == Int.MAX_VALUE) -1 else result)
}
