package alogorizm.sort.insertionsort

import java.util.*

fun insertSort(list: MutableList<Int>) {
    val size = list.size
    for (i in 0 until size - 1) {
        for (j in i + 1 downTo 1) {
            if (list[j - 1] > list[j]) {
                Collections.swap(list, j, j - 1)
            }
        }
    }
}

fun main() {
    val list = Array(10) { kotlin.random.Random.nextInt(0, 100) }.toMutableList()
    println(list)
    insertSort(list)
    println(list)
}
