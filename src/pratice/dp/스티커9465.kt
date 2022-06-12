package pratice.dp

import java.lang.Integer.max

fun main() {
    val T = readln().toInt()
    repeat(T){
        val N = readln().toInt()
        val dp = Array(N + 1){IntArray(3)}
        val A = readln().split(" ").map { it.toInt() }.toIntArray()
        val B  = readln().split(" ").map { it.toInt() }.toIntArray()

        dp[1][0] = 0 // 0은 건너 뜀
        dp[1][1] = A[0] // 1은 A 선택
        dp[1][2] = B[0] // 2는 B 선택
        for(i in 2..N){
            dp[i][0] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2])
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + A[i - 1]
            dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + B[i - 1]
        }

        println(max(max(dp[N][0], dp[N][1]), dp[N][2]))
    }
}