package pratice.binarysearch

import kotlin.math.abs

fun main() {
    var N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    arr.sort()

    var v1 = 0
    var v2 = 0
    var minSum = Int.MAX_VALUE
    for (i in 0 until arr.size - 1) {

        val res = lowerBound(-arr[i], arr)
        if (i < res - 1 && abs(arr[i] + arr[res - 1]) < minSum) {
            minSum = abs(arr[i] + arr[res - 1])
            v1 = arr[i]
            v2 = arr[res - 1]
        }

        if (res < arr.size && abs(arr[res] + arr[i]) < minSum) {
            minSum = abs(arr[i] + arr[res])
            v1 = arr[i]
            v2 = arr[res]
        }
    }

    println("$v1 $v2")
}
private fun lowerBound(num: Int, arr: MutableList<Int>): Int {
    var L = 0
    var R = arr.size - 1
    var res = R
    while (L <= R) {
        val mid = (L + R) / 2
        if (num <= arr[mid]) {
            res = mid
            R = mid - 1
        } else {
            L = mid + 1
        }
    }
    return res
}
