package pratice.backtraking

private var used = BooleanArray(0)
private var selected = IntArray(0)
private val buffer: StringBuffer = StringBuffer()
private var N = 0
private var M = 0

fun main(){
    val num = readln().split(" ").map { n -> n.toInt() }.toList()
    N = num[0]
    M = num[1]
    used = BooleanArray(N + 1)
    selected = IntArray(M + 1)
    recFunc(1)
    println(buffer)
}


private fun recFunc(k: Int) {
    if (k >= M + 1){
        for(i in 1 until selected.size){
            buffer.append("${selected[i]} ")
        }
        buffer.append("\n")
    }else {
        for(i in 1 .. N){
            if(!used[i]){
                selected[k] = i
                used[i] = true
                recFunc(k + 1)
                used[i] = false
                selected[k] = 0
            }
        }
    }
}
