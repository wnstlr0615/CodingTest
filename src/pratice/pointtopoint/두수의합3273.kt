package pratice.pointtopoint

fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val X = readln().toInt()

    arr.sort()
    var L = 0
    var R = N - 1
    var cnt = 0
    while (L < R) {
        if (arr[L] + arr[R] < X)L++
        else if (arr[L] + arr[R] > X)R--
        else {
            cnt++
            L++
        }
    }
    println(cnt)
}
