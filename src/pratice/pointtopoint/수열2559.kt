package pratice.pointtopoint

import kotlin.math.max

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toList()
    var sum = 0L
    var R = 0
    var cnt = 0
    var max = Long.MIN_VALUE
    for (L in 0..N - K) {
        while (R < N && L <= R && cnt < K) {
            sum += arr[R++]
            cnt++
        }
        max = max(max, sum)
        sum -= arr[L]
        cnt--
    }
    println(max)
}
