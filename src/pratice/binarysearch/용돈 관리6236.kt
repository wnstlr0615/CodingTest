package pratice.binarysearch

import kotlin.math.max

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()

    repeat(N) {
        arr.add(readln().toInt())
    }

    lowerBound(arr, M)
}

private fun lowerBound(arr: MutableList<Int>, m: Int) {
    var L = arr[0]
    var R = 1000000000
    for (num in arr) L = max(L, num)
    var res = R
    while (L <= R) {
        val mid = (L + R) / 2
        if (determination(arr, m, mid)) {
            res = mid
            R = mid - 1
        } else {
            L = mid + 1
        }
    }
    println(res)
}

private fun determination(arr: MutableList<Int>, m: Int, mid: Int): Boolean {
    var sum = 0
    var cnt = 0

    for (num in arr) {
        if (sum + num <= mid) {
            sum += num
        } else {
            cnt ++
            sum = num
        }
    }
    return cnt < m
}
