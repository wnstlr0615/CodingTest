package pratice.backtraking

//n - 1 개 카드로 중복 없이 n-1개를 순서있게 나열하는 방법

private var N = 0
private var num = intArrayOf()
private var chars = charArrayOf('+', '-', '*', '/')
private val selected = mutableListOf<Char>()
private var operator = listOf<Char>()
private var used = BooleanArray(0)
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

private fun main(){
    input()
    func(0)
    println(max)
    println(min)
}

private fun func(k: Int) {
    if(k >= N - 1){
        val result = cal()
        if(result > max) max = result
        if(result< min) min = result
    }else{
        for(i in 0 until N - 1){
            if(!used[i]){
                selected.add(operator[i])
                used[i] = true
                func(k + 1)
                used[i] = false
                selected.removeLast()
            }
        }
    }
}

fun cal(): Int {
    var sum = num[0]
    for((idx, c) in selected.withIndex()){
        when(c){
            '+' -> { sum += num[idx + 1]}
            '-' -> { sum -= num[idx + 1]}
            '/' -> {  sum = if(sum > 0)   sum / num[idx + 1] else -((-sum) / num[idx + 1])}
            '*' -> { sum *= num[idx + 1]}
        }
    }
    return sum
}

private fun input() {
    N = readln().toInt()
    num = readln().split(" ").map { it.toInt() }.toIntArray()
    operator = readln().split(" ").map { it.toInt() }.flatMapIndexed { idx, num -> List<Char>(num) { chars[idx] } }
    used = BooleanArray(N - 1)
}