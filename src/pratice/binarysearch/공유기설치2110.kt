package pratice.binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()
    repeat(N) {
        arr.add(readln().toInt())
    }
    arr.sort()
    val res = lowerBound(arr, M)
    println(res)
}
private fun lowerBound(arr: MutableList<Int>, M: Int): Int {
    var L = 1
    var R = arr[arr.size - 1] - arr[0]
    var res = L

    while (L <= R) {
        val mid = (L + R) / 2
        if (useAble(arr, mid, M)) {
            res = mid
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return res
}

fun useAble(arr: MutableList<Int>, x: Int, M: Int): Boolean {
    var cnt = 1
    var last = arr[0]
    for (i in 1 until arr.size) {
        if (arr[i] - last >= x) {
            cnt++
            last = arr[i]
        }
        if (cnt >= M) {
            return true
        }
    }
    return false
}
