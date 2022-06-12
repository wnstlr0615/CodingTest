package pratice.dp

fun main() {
    val T = readln().toInt()
    val dp = Array(65){LongArray(10)}
    dp[1].fill(1L)

    for (i in 2..64){
        for(j in 0..9){
            for(k in j ..9){
                dp[i][j] += dp[i - 1][k]
            }
        }
    }
    repeat(T){
        val N = readln().toInt()
        println(dp[N].sum())
    }
}