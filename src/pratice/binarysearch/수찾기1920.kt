package pratice.binarysearch

fun main() {
    val N = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    a.sort()

    var M = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }.toMutableList()

    for (num in b) {
        println(binarySearch(a, num))
    }
}

private fun binarySearch(arr: MutableList<Int>, num: Int): Int {
    var L = 0
    var R = arr.size - 1
    while (L <= R) {
        val mid = (L + R) / 2
        if (arr[mid] == num) {
            return 1
        } else if (arr[mid] < num) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return 0
}
