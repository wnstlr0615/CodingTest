package pratice.sort

fun main(){
    val N = readln().toInt()
    val arrList = mutableListOf<Arr>()
    val p = IntArray(N)
    readln().split(" ")
        .map { it.toInt() }
        .withIndex()
        .forEach{ (idx, num)->
            arrList.add(Arr(idx, num))
        }
    arrList.sort()

    for(i in 0 until N){
        p[arrList[i].idx] = i
    }
    p.forEach { print("$it ") }
}
class Arr(
    val idx: Int,
    val num: Int
): Comparable<Arr>{
    override fun compareTo(other: Arr): Int {
        return num - other.num
    }
}


