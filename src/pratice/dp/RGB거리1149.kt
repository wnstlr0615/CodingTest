package pratice.dp

import kotlin.math.min

fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1){Array(3){0}}
    var arr = Array(N + 1){Array(3){0}}
    for(i in 1 .. N){
        val (r, g, b) = readln().split(" ").map{it.toInt()}
        arr[i][0] = r
        arr[i][1] = g
        arr[i][2] = b
    }
    dp[1][0] = arr[1][0]
    dp[1][1] = arr[1][1]
    dp[1][2] = arr[1][2]
    for(i in 2..N){
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]
    }
    val price = min(min(dp[N][0], dp[N][1]), dp[N][2])
    println(price)
}