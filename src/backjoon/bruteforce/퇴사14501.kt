package backjoon.bruteforce

import kotlin.math.max


private var days = mutableListOf<Int>()
private var prices = mutableListOf<Int>()
private var N = 0
private var max = Int.MIN_VALUE

fun main(){
    input()
    pro(0, 0)
    println(max)
}

fun pro(day: Int, sumPrice: Int) {
    if(day == N) max = max(max, sumPrice)
    if(day >= N) return
    pro(day + days[day], sumPrice + prices[day])
    pro(day + 1, sumPrice)
}

private fun input() {
    N = readln().toInt()
    repeat(N) {
        val ints = readln().split(" ").map { it.toInt() }.toIntArray()
        days.add(ints[0])
        prices.add(ints[1])
    }


}


