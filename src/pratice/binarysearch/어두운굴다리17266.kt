package pratice.binarysearch

import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toList()

    lowerBound(arr, N)
}

private fun lowerBound(arr: List<Int>, N: Int) {
    var L = 0
    var R = Int.MAX_VALUE
    var res = R
    while (L <= R) {
        val mid = (L + R) / 2

        if (determination(arr, N, mid)) {
            res = mid
            R = mid - 1
        } else {
            L = mid + 1
        }
    }
    println(res)
}

private fun determination(arr: List<Int>, N: Int, height: Int): Boolean {
    // 높이 가 height일 때 만족하지 못하면 true
    if (arr[0] > height) return false
    if (abs(N - arr[arr.size - 1]) > height) return false

    for (i in 1 until arr.size) {
        if (arr[i] - arr[i - 1] > 2 * height) {
            return false
        }
    }
    return true
}
