package pratice.pointtopoint

fun main() {
    val (aLen, bLen) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.toList()
    val b = readln().split(" ").map { it.toInt() }.toList()

    var l1 = 0
    var l2 = 0
    val buffer = StringBuffer()
    while (l1 < aLen && l2 < bLen) {
        if (a[l1] <= b[l2]) {
            buffer.append(a[l1++])
        } else {
            buffer.append(b[l2++])
        }
        buffer.append(" ")
    }
    while (l1 < aLen) {
        buffer.append(a[l1++]).append(" ")
    }
    while (l2 < bLen) {
        buffer.append(b[l2++]).append(" ")
    }
    println(buffer.toString())
}
