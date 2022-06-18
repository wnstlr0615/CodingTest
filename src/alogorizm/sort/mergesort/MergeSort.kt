package alogorizm.sort.mergesort

import kotlin.random.Random

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    val mergeList = mutableListOf<Int>()
    var lp = 0
    var rp = 0

    while (lp < left.size && rp < right.size) {
        if (left[lp] <= right[rp]) {
            mergeList.add(left[lp])
            lp++
        } else {
            mergeList.add(right[rp])
            rp++
        }
    }

    while (lp < left.size) {
        mergeList.add(left[lp])
        lp++
    }
    while (rp < right.size) {
        mergeList.add(right[rp])
        rp++
    }
    return mergeList
}

fun split(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1) {
        return list
    }
    val mid = list.size / 2
    val left = split(ArrayList(list.subList(0, mid)))
    val right = split(ArrayList(list.subList(mid, list.size)))

    return merge(left, right)
}

fun main() {
    val list = Array(100) { Random.nextInt(0, 100) }.toMutableList()
    println(list)
    val sortList = split(list)
    println(sortList)
}
