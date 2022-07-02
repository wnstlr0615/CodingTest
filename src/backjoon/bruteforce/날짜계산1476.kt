package backjoon.bruteforce

fun main(){
    val arr = readln().split(" ").map { it.toInt() }.toList()
    var x = 0
    var y = 0
    var z = 0
    var year = 0
    while(arr[0] != x
            || arr[1] != y
                || arr[2] != z){
        x++
        y++
        z++
        year++
        if(x % 16 == 0){x = 1}
        if(y % 29 == 0){y = 1}
        if(z % 20 == 0){z = 1}
    }
    println(year)

}