package pratice.dp

import java.lang.Integer.max

fun main() {
    val N = readln().toInt()
    val arr = Array(N + 1){0}
    for (i in 1 .. N){
        arr[i] = readln().toInt()
    }
    val dp =  Array(N + 1){IntArray(2)}
    dp[1][0] = arr[1]
    if(N >= 2){
        dp[2][0] = dp[1][0] + arr[2]
        dp[2][1] = arr[2]
    }

    for(i in 3..N){
        dp[i][0] = dp[i - 1][1] + arr[i]
        dp[i][1] = max(dp[i - 2][0], dp[i - 2][1]) + arr[i]
        dp[i][1] = max(dp[i][1], max(dp[i - 3][0], dp[i - 3][1]) + arr[i])
    }
    println(max(max(dp[N][0], dp[N][1]), max(dp[N - 1][0], dp[N - 1][1])))
}