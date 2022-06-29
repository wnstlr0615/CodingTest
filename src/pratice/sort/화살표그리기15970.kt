package pratice.sort

import kotlin.math.abs
import kotlin.math.min


fun main(){
    val N = readln().toInt()
    val points= mutableListOf<PointColor>()
    for(i in 0 until N){
        val arr = readln().split(" ").map { it.toInt() }
        points.add(PointColor(arr[0], arr[1]))
    }
    points.sort()
    var sum = 0

    for(i in 0 until N){
        var leftDis = Int.MAX_VALUE
        var rightDis = Int.MAX_VALUE
        if(i > 0 && points[i].color == points[i - 1].color){
            leftDis = abs(points[i].x - points[i - 1].x)
        }
        if(i < N - 1 && points[i].color == points[i + 1].color){
            rightDis = abs(points[i].x - points[i + 1].x)
        }
        sum += min(leftDis, rightDis)
    }
    println(sum)
}
class PointColor(
    val x: Int,
    val color: Int
): Comparable<PointColor>{
    override fun compareTo(other: PointColor): Int {
        if(color != other.color){
            return  color - other.color
        }
        return x - other.x 
    }
}