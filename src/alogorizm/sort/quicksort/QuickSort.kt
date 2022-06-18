package alogorizm.sort.quicksort

import kotlin.random.Random

fun quickSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1) {
        return list
    }
    val pivot = 0
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    for (i in 1 until list.size) {
        if (list[i] <= list[pivot]) {
            left.add(list[i])
        } else {
            right.add(list[i])
        }
    }
    println(left)
    println(right)

    val mergeSortList = mutableListOf<Int>()
    mergeSortList.addAll(quickSort(left))
    mergeSortList.add(list[pivot])
    mergeSortList.addAll(quickSort(right))
    return mergeSortList
}

fun main() {
    val list = Array(10) { Random.nextInt(0, 100) }.toMutableList()
    val sortList = quickSort(list)
    println(list)
    println(sortList)
}
