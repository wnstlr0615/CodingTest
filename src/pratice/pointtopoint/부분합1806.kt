package pratice.pointtopoint

import kotlin.math.min

fun main() {
    val (N, S) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toList()
    var sum = 0
    var R = 0
    var ans = N + 1
    for (L in 0 until N) {
        while (R < N && sum < S) {
            sum += arr[R]
            R++
        }
        if (sum >= S) {
            ans = min(ans, R - L)
        }
        sum -= arr[L]
    }
    println(if (ans == N + 1) 0 else ans)
}
