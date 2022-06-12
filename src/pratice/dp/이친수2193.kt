package pratice.dp

fun main() {
    val N = readln().toInt()
    val dp = LongArray(N + 2)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2
    for (i in 4..N){
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[N])
}