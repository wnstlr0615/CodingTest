package pratice.binarysearch

import kotlin.math.max
/** 정렬하면 틀리는 문제*/
fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    lowerBound(arr, M)
}

private fun lowerBound(arr: MutableList<Int>, m: Int) {
    var L = arr[0]
    var R = 1000000000
    var res = 0
    for (num in arr) L = max(num, L)
    while (L <= R) {
        val mid = (L + R) / 2
        if (isAble(arr, m, mid)) {
            res = mid
            R = mid - 1
        } else {
            L = mid + 1
        }
    }
    println(res)
}

private fun isAble(arr: MutableList<Int>, m: Int, mid: Int): Boolean {
    var sum = 0
    var cnt = 0
    for (num in arr) {
        if (sum + num > mid) {
            cnt++
            sum = num
        } else {
            sum += num
        }
    }
    return cnt < m
}
