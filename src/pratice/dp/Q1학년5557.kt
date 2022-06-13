package pratice.dp

fun main() {
    val N = readln().toInt()
    val dp = Array(N + 1){LongArray(21)}
    val arr = IntArray(N + 1)
    readln().split(" ").map {it.toInt()}
        .forEachIndexed{idx , value -> arr[idx + 1] = value}
    dp[1][arr[1]] = 1
    for(i in 2.. N){
       for(prev in 0..20){
           for(cur in listOf(prev - arr[i], prev + arr[i])){
               if( cur < 0 || cur > 20)continue
               dp[i][cur] += dp[i - 1][prev]
           }
       }
    }
    println(dp[N - 1][arr[N]])
}