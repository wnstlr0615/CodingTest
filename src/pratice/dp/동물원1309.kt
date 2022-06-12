package pratice.dp

fun main() {
    val N = readln().toInt()
    val dp = IntArray(N + 3)
    dp[1] = 3
    dp[2] =7
    for(i in 3..N){
        dp[i] = ((2 * dp[i - 1]) % 9901 + dp[i - 2] % 9901) % 9901
    }
    println(dp[N])
}