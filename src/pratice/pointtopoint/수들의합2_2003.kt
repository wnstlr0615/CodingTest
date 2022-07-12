package pratice.pointtopoint

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    var cnt = 0
    var R = 0
    var sum = 0
    for (L in arr.indices) {
        while (R < N && sum < M) {
            sum += arr[R]
            R++
        }
        if (sum == M) {
            cnt++
        }
        sum -= arr[L]
    }
    println(cnt)
}
