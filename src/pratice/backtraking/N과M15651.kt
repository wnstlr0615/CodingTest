package pratice.backtraking

private var selected = IntArray(0)
private val buffer: StringBuffer = StringBuffer()
private var N = 0
private var M = 0
fun main(){
    val num = readln().split(" ").map { n -> n.toInt() }.toList()
    N = num[0]
    M = num[1]
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
            selected[k] = i
            recFunc(k + 1)
            selected[k] = 0
        }
    }
}