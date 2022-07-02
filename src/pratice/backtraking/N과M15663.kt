package pratice.backtraking

private var N = 0
private var M = 0
private var num = emptyList<Int>()
private val buffer = StringBuffer()
private var selected = IntArray(0)
private var used = BooleanArray(0)
fun main(){
    input()
    recFunc(0)
    println(buffer)
}

private fun input() {
    val ints = readln().split(" ").map { n -> n.toInt() }
    N = ints[0]
    M = ints[1]
    selected = IntArray(M)
    num = readln().split(" ").map { s -> s.toInt() }.toList()
    num = num.sorted()
    used = BooleanArray(N)
}

private fun recFunc(k: Int) {
    if(k >= M){
        for(i in 0 until  M){
            buffer.append("${selected[i]} ")
        }
        buffer.append("\n")
    }else{
        var lastNum = -1
        for(i in  0 until num.size){
           if(!used[i] && lastNum!= num[i]){
               lastNum = num[i]
               selected[k] = num[i]
               used[i] = true
               recFunc(k + 1)
               used[i] = false
               selected[k] = 0
           }
        }
    }
}
