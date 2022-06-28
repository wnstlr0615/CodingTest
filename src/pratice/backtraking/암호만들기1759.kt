package pratice.backtraking

import java.util.*

private var L = 0
private var C = 0

private var list = CharArray(0)
private var selected = mutableListOf<Char>()
private var used = BooleanArray(0)
private var buffer = StringBuffer()
private val vowels = charArrayOf('a', 'e', 'i', 'u', 'o')

fun main(){
    input()
    pro(0, 'a'.toInt() - 1)
    println(buffer)
}

fun check(): Boolean {
    var consCnt = 0
    var vowelCnt = 0

    for(c in selected){
        if(c in vowels){
            vowelCnt++
        }else{
            consCnt++
        }
    }
    return consCnt >= 2 && vowelCnt > 0
}

fun pro(idx: Int, lastWord: Int) {
    if(idx >= L){
        if(check()){
            selected.forEach(buffer::append)
            buffer.append("\n")
        }
    }else{
        for (i in list.indices){
            if(lastWord.toChar() < list[i] && !used[i]){
                selected.add(list[i])
                used[i] = true
                pro(idx + 1, list[i].toInt())
                used[i] = false
                selected.removeLast()
            }
        }
    }

}

private fun input() {
    val toList = readln().split(" ").map { it.toInt() }.toList()
    L = toList[0]
    C = toList[1]
    used = BooleanArray(C)
    list  = readln().split(" ").map { it.toCharArray()[0] }.toCharArray()
    Arrays.sort(list)
}