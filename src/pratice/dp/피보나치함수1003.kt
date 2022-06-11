package pratice.dp

fun main(){
    val T = readln().toInt()
    val dp = Array(41){Array(2){0}}
    dp[0][0] = 1
    dp[1][1] = 1
    for(i in 2 until dp.size){
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1]
    }
    repeat(T){
        val N = readln().toInt()
        println("${dp[N][0]} ${dp[N][1]}")
    }
}