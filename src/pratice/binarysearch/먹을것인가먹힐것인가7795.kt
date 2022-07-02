package pratice.binarysearch


fun main() {
    val T = readln().toInt()
    repeat(T) {
        var cnt = 0
        val (aSize, bSize) = readln().split(" ").map { it.toInt() }
        val a = readln().split(" ").map { it.toInt() }.toMutableList()
        val b = readln().split(" ").map { it.toInt() }.toMutableList()

        a.sort()
        b.sort()
        for(num in a) {
            cnt += lowerBound(num, b)
        }
        println(cnt)
    }
}

fun lowerBound(num: Int, arr: MutableList<Int>): Int {
    var L = 0
    var R = arr.size - 1

    while(L <= R){
        val mid = (L + R) / 2
        if(num > arr[mid] ){
            L = mid + 1
        }else{
            R = mid - 1
        }
    }
    return L
}
