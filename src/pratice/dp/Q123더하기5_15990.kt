package pratice.dp

fun main() {
    val T = readln().toInt()
    val dp = Array(100_001){IntArray(4)}
    dp[1][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for( i in 4..100_000){
        dp[i][1] =  (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009
        dp[i][2] =  (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009
        dp[i][3] =  (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009
    }
    repeat(T){
        val n = readln().toInt()
        var ans = 0
        for(i in 1..3){
            ans += dp[n][i]
            ans %= 1_000_000_009
        }
        println(ans)
    }
}