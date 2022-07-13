package pratice.pointtopoint

import kotlin.math.min

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N)
    for (i in arr.indices) {
        arr[i] = readln().toInt()
    }
    arr.sort()
    var R = 1
    var minValue = Int.MAX_VALUE
    for (L in 0 until N - 1) {
        while (R < N - 1 && arr[R] - arr[L] < M) {
            R++
        }
        if (arr[R] - arr[L] >= M) {
            minValue = min(minValue, arr[R] - arr[L])
        }
    }
    println(minValue)
}
