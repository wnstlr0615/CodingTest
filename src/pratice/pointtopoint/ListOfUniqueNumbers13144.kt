package pratice.pointtopoint

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toList()
    var R = 0
    val check = BooleanArray(100_001)
    var cnt = 0L
    for (L in 0 until N) {
        while (R < N && !check[arr[R]]) {
            check[arr[R]] = true
            R++
        }
        cnt += (R - L)
        check[arr[L]] = false
    }
    println(cnt)
}
