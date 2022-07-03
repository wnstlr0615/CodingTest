package pratice.binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val a = mutableListOf<String>()
    val b = mutableListOf<String>()

    repeat(N) {
        a.add(readln())
    }
    repeat(M) {
        b.add(readln())
    }
    a.sort()
    b.sort()
    var cnt = 0
    val buffer = StringBuffer()
    for (name in b) {
        if (binarySearch(a, name)) {
            cnt++
            buffer.append(name).append("\n")
        }
    }
    println(cnt)
    println(buffer.toString())
}

private fun binarySearch(names: MutableList<String>, name: String): Boolean {
    var L = 0
    var R = names.size - 1
    while (L <= R) {
        val mid = (L + R) / 2
        if (names[mid] == name) {
            return true
        } else if (names[mid] < name) {
            L = mid + 1
        } else {
            R = mid - 1
        }
    }
    return false
}
