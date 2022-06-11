package pratice.dp

fun main() {
    val dp = Array(100_001){0L}
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 2
    dp[4] = dp[0] + dp[2]
    dp[5] = dp[3] + dp[1]

    for(i in 6 until 100_001){
        dp[i] = (dp[i - 2] % 1_000_000_009 + dp[i - 4] % 1_000_000_009 + dp[i - 6] % 1_000_000_009) % 1_000_000_009
    }
    val T = readln().toInt()
    repeat(T){
        println(dp[readln().toInt()])
    }
}