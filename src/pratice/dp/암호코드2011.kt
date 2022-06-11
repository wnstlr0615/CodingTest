package pratice.dp

fun main() {
    val str = readln()
    val dp = Array(str.length + 1){0}

    if(str[0] != '0') dp[0] = 1

    for (i in 1 until str.length) {
        if(str[i] != '0') dp[i] = dp[i - 1]
        if(check(str[i - 1], str[i])){
            if(i >= 2) dp[i] += dp[i - 2]
            else dp[i] += 1
            dp[i] %= 1_000_000
        }
    }
    println(dp[str.length - 1])
}

fun check(a: Char, b: Char) = when(a){
         '1' -> true
        '2' -> b <= '6'
        else -> false
    }

