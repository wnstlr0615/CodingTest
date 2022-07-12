package pratice.pointtopoint

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    var cnt = 0
    arr.sort()

    for (x in 0 until N) {
        if (func(x, arr)) {
            cnt++
        }
    }
    println(cnt)
}

private fun func(x: Int, arr: MutableList<Int>): Boolean {
    var L = 0
    var R = arr.size - 1
    val target = arr[x]

    while (L < R) {
        if (L == x) L++
        else if (R == x) R--
        else {
            if (arr[L] + arr[R] > target) R--
            else if (arr[L] + arr[R] < target) L++
            else return true
        }
    }
    return false
}
