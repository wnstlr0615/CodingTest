package pratice.dp

import java.lang.Integer.max

fun main() {
    val N = readln().toInt()
    val P = Array(N + 1){0}
    val dp = Array(N + 1){0}
    val str = readln().split(" ")
    for (i in 1..N) {
        P[i] = str[i - 1].toInt()
        dp[i] = P[i]
    }
    for(i in 1..N){
      for(j in 0.. i/2 )
          dp[i] = max(dp[i], dp[i-j] + dp[j])
    }
    println(dp[N])
}