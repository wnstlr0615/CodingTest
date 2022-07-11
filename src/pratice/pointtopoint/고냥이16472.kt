package pratice.pointtopoint

import kotlin.math.max

fun main() {
    val N = readln().toInt()
    val str = readln()
    val engCnt = IntArray(26)
    var cnt = 0
    var max = Int.MIN_VALUE
    var L = 0
    for (R in str.indices) {
        if (engCnt[str[R] - 'a'] == 0) {
            cnt++
        }
        engCnt[str[R] - 'a']++
        while (cnt > N) {
            if (engCnt[str[L] - 'a'] == 1) {
                cnt--
            }
            engCnt[str[L] - 'a']--
            L++
        }
        max = max(max, R - L + 1)
    }
    println(max)
}
