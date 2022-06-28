package pratice.backtraking

private var N =0
private var S = 0
private var cnt = 0
private var num = emptyList<Int>()

private fun main(){
    input()
    recFunc(0, 0)
    if(S == 0) cnt--
    println(cnt)
}

fun recFunc(idx: Int, sum: Int) {
    if(idx >= N){
        if(sum == S){
            cnt++
        }
    }else{
        recFunc(idx + 1, sum + num[idx])
        recFunc(idx + 1, sum)
    }
}

private fun input() {
    num = readln().split(" ").map { it.toInt() }.toList()
    N = num[0]
    S = num[1]
    num = readln().split(" ").map { it.toInt() }.toList()


}
