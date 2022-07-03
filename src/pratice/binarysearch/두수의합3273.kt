package pratice.binarysearch

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    val x = readln().toInt()
    var cnt = 0
    arr.sort()
    for (i in 0 until N - 1) {
        if (binarySearch(arr, i, x)) {
            cnt++
        }
    }
    println(cnt)
}

private fun binarySearch(arr: MutableList<Int>, idx: Int, sum: Int): Boolean {
    var L = idx + 1
    var R = arr.size - 1
    while (L <= R) {
        val mid = (L + R) / 2
        if (arr[idx] + arr[mid] == sum) {
            return true
        } else if (arr[idx] + arr[mid] < sum) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return false
}
