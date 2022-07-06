package pratice.pointtopoint

import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    arr.sort()

    var L = 0
    var R = N - 1
    var v1 = 0
    var v2 = 0
    var bestNum = Int.MAX_VALUE
    while (L < R) {
        val sum = arr[L] + arr[R]
        if (abs(sum) < bestNum) {
            bestNum = abs(sum)
            v1 = arr[L]
            v2 = arr[R]
        }
        if (sum > 0) {
            R--
        } else {
            L++
        }
    }
    println("$v1  $v2")
}
