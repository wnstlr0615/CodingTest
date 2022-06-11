package pratice.dp

fun main() {
    val dp = Array(21){0}
    dp[0] = 0
    dp[1] = 1
    for (i  in 2 until 21){
        dp[i] = dp[i - 2] + dp[i - 1]
    }
    println(dp[readln().toInt()])
}