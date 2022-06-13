package pratice.dp

import java.lang.Integer.max

fun main() {
    val split = readln().split(" ").map { it.toInt() }
    val N = split[0]
    val S = split[1]
    val M = split[2]

    val arr = IntArray(N + 1)
    readln().split(" ").map { it.toInt() }
        .forEachIndexed{idx, value -> arr[idx + 1] = value}
    val dp = Array(N + 1){BooleanArray(M + 1)}

    dp[0][S] = true
    var ans = 0
    for(i in 1..N){
       var flag = false
        ans = 0
        for(prev in 0..M){
            if(!dp[i - 1][prev]) continue
            for(cur in listOf(prev - arr[i], prev + arr[i])){
                if(cur < 0 || cur > M)continue
                ans = max(ans, cur)
                dp[i][cur] = true
                flag = true
            }
        }
        if(!flag){
            println(-1)
            return
        }
    }
    println(ans)
}