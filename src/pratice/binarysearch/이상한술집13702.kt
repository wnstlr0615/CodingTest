package pratice.binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()
    repeat(N) {
        arr.add(readln().toInt())
    }
    arr.sort()
    upperBound(arr, M)
}

private fun upperBound(arr: MutableList<Int>, M: Int) {
    var L = 0L
    var R = (Int.MAX_VALUE).toLong()
    var res = 0

    while (L <= R) {
        val mid = ((L + R) / 2).toInt()
        if (determination(arr, M, mid)) {
            res = mid
            L = mid.toLong() + 1
        } else {
            R = mid.toLong() - 1
        }
    }
    println(res)
}

private fun determination(arr: MutableList<Int>, divideCnt: Int, mid: Int): Boolean {
    var cnt = 0L
    if (mid == 0) return false
    for (num in arr) {
        cnt += (num / mid)
    }
    return cnt >= divideCnt
}
