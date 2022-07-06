package pratice.binarysearch

import kotlin.math.min

fun main() {
    val (N, K) = input()
    pro(N, K)
}

private fun pro(N: Int, K: Int) {
    var L = 1L
    var R: Long = (N.toLong() * N)
    var res = 0L
    while (L <= R) {
        val mid: Long = (L + R) / 2
        if (determination(N, K, mid)) {
            res = mid
            R = mid - 1
        } else {
            L = mid + 1
        }
    }
    println(res)
}

private fun input(): List<Int> {
    val N = readln().toInt()
    val K = readln().toInt()
    return listOf(N, K)
}

private fun determination(N: Int, K: Int, mid: Long): Boolean {
    var cnt = 0L
    for (i in 1..N) {
        cnt += min(N.toLong(), mid / i)
    }
    return cnt >= K
}
