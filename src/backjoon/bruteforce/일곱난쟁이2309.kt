package backjoon.bruteforce

private var used = BooleanArray(9)
private var check = false
fun main(){
    val heights = ArrayList<Int>()
    for(i in 0.. 8){
        heights.add(readln().toInt())
    }
    heights.sort()
    val selected = ArrayList<Int>()

    recFunc(0, selected,heights, 0)
}

fun recFunc(idx: Int, selected: ArrayList<Int>, heights: ArrayList<Int>, sum: Int) {
    if(idx >= 7){
        if(sum == 100){
            selected.forEach(::println)
            check = true
        }
    }else{
        if(!check)
        for(i in 0 .. 8){
            if(!used[i]){
                used[i] = true
                selected.add(heights[i])
                recFunc(idx + 1, selected, heights, sum + heights[i])
                selected.removeLast()
                used[i] = false
            }
        }
    }
}
