package pratice.binarysearch

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    val money = readln().toInt()

    arr.sort()

    lowerBound(arr, money)
}

private fun lowerBound(arr: MutableList<Int>, money: Int) {
    var L = 0
    var R = arr[arr.size - 1]
    var res = 0
    while (L <= R) {
        val mid = (L + R) / 2
        if (divideAble(arr, money, mid)) {
            res = mid
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    println(res)
}
private fun divideAble(arr: MutableList<Int>, money: Int, mid: Int): Boolean {
    var sum = 0
    for (num in arr) {
        if (num <= mid) {
            sum += num
        } else {
            sum += mid
        }
    }
    return sum <= money
}
