package pratice.dp

fun main() {
    val dp = Array(1_000_001){0L}
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for(i in 4 until 1_000_001){
        dp[i] = (dp[i - 1] % 1_000_000_009 + dp[i - 2] % 1_000_000_009 + dp[i - 3] % 1_000_000_009) % 1_000_000_009
    }
    val T = readln().toInt()
    repeat(T){
        println(dp[readln().toInt()])
    }
}