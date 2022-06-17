package alogorizm.sort.selectsort

import java.util.*
import kotlin.random.Random

fun selectSort(list: MutableList<Int>) {
    val size = list.size
    for (i in 0 until size - 1) {
        var minIdx = i
        for (j in i + 1 until size) {
            if (list[minIdx] > list[j]) {
                minIdx = j
            }
        }
        if (minIdx != i) {
            Collections.swap(list, minIdx, i)
        }
    }
}
fun main() {
    val mutableList = Array(10) { Random.nextInt(0, 100) }.toMutableList()
    println(mutableList)
    selectSort(mutableList)
    println(mutableList)
}
