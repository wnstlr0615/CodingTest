package pratice.binarysearch

fun main() {
    val N = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    val M = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }.toMutableList()
    val buffer = StringBuffer()
    a.sort()
    for (num in b) {
        val left = lowerBound(a, num)
        val right = upperBound(a, num)
        buffer.append(right - left).append(" ")
    }
    println(buffer.toString())
}

private fun lowerBound(arr: MutableList<Int>, num: Int): Int {
    var L = 0
    var R = arr.size - 1
    while (L <= R) {
        val mid = (L + R) / 2
        if (arr[mid] < num) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return L
}

private fun upperBound(arr: MutableList<Int>, num: Int): Int {
    var L = 0
    var R = arr.size - 1
    while (L <= R) {
        val mid = (L + R) / 2
        if (arr[mid] <= num) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return L
}
