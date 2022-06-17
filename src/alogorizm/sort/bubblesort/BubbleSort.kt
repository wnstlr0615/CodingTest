package alogorizm.sort.bubblesort

import java.util.Collections
import kotlin.random.Random

fun bubblesSort(list: MutableList<Int>) {
    val size = list.size
    for (i in 0 until size) {
        var swap = false
        for (j in 0 until size - i - 1) {
            if (list[j] > list[j + 1 ]) {
                Collections.swap(list, j, j + 1)
                swap = true
            }
        }
        if (!swap) {
            break
        }
    }
}

fun main() {
    val list = Array(10) { Random.nextInt(0, 100) }.toMutableList()
    println(list)
    bubblesSort(list)
    println(list)
}
