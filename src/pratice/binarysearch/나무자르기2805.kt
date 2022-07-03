package pratice.binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    arr.sort()
    val res = lowerBound(arr, M)
    println(res)
}

private fun lowerBound(arr: MutableList<Int>, M: Int): Int {
    var L = 0
    var R = arr[arr.size - 1]
    var res = L

    while (L <= R) {
        val mid = (L + R) / 2
        if (cutAble(arr, mid, M)) {
            res = mid
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return res
}

private fun cutAble(arr: MutableList<Int>, x: Int, M: Int): Boolean {
    var sum = 0L
    for (num in arr) {
        sum += if (num > x) num - x else 0
        if (sum >= M) return true
    }
    return false
}
