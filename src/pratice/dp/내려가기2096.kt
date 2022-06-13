package pratice.dp

import java.lang.Integer.max
import java.lang.Integer.min

fun main() {
    val N = readln().toInt()
    val dp = Array(2){Array(N + 1){IntArray(3)}}
    val arr = Array(N + 1){IntArray(3)}
    for( i in 1 .. N )
    arr[i] = readln().split(" ").map { it.toInt() }.toIntArray()

    dp[0][1][0] = arr[1][0]
    dp[0][1][1] = arr[1][1]
    dp[0][1][2] = arr[1][2]
    dp[1][1][0] = arr[1][0]
    dp[1][1][1] = arr[1][1]
    dp[1][1][2] = arr[1][2]

    for(i in 2..N){
        dp[0][i][0] = min(dp[0][i - 1][0], dp[0][i - 1][1]) + arr[i][0]
        dp[0][i][1] = min(min(dp[0][i - 1][0], dp[0][i - 1][1]), dp[0][i - 1][2]) + arr[i][1]
        dp[0][i][2] = min(dp[0][i - 1][1], dp[0][i - 1][2]) + arr[i][2]
        dp[1][i][0] = max(dp[1][i - 1][0], dp[1][i - 1][1]) + arr[i][0]
        dp[1][i][1] = max(max(dp[1][i - 1][0], dp[1][i - 1][1]), dp[1][i - 1][2]) + arr[i][1]
        dp[1][i][2] = max(dp[1][i - 1][1], dp[1][i - 1][2]) + arr[i][2]
    }
    val min = min(min(dp[0][N][0], dp[0][N][1]), dp[0][N][2])
    val max = max(max(dp[1][N][0], dp[1][N][1]), dp[1][N][2])

    println("$max $min")
}