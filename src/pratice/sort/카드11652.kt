package pratice.sort


fun main(){
    val N = readln().toInt()
    val a = LongArray(N + 1)
    for(i in 1 .. N){
        a[i] = readln().toLong()
    }
    a.sort(1, N + 1)
    var mostCnt = 1
    var cnt = 1
    var mode = a[1]
    for(i in 1 .. N){
        if(a[i] == a[i - 1]){
            cnt++
        }else{
            cnt = 1
        }
        if(cnt > mostCnt){
            mostCnt = cnt
            mode = a[i]
        }
    }
    println(mode)
}