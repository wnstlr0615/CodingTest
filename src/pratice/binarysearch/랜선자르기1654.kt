package pratice.binarysearch

fun main() {
    val (K, N) = readln().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()
    repeat(K) {
        arr.add(
            readln().toInt()
        )
    }
    arr.sort()

    lowerBound(arr, N)
}

private fun lowerBound(arr: MutableList<Int>, needLineCnt: Int) {
    var L = 0L
    var R = Int.MAX_VALUE.toLong()
    var res = L
    while (L <= R) {
        val mid = (L + R) / 2
        if (cutAble(arr, mid, needLineCnt)) {
            res = mid
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    println(res)
}

private fun cutAble(arr: MutableList<Int>, num: Long, needLineCnt: Int): Boolean {
    var cnt = 0L
    for (len in arr) {
        cnt += (len / num).toLong()
    }
    return cnt >= needLineCnt
}
