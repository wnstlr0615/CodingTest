package alogorizm.backtracking

import kotlin.math.abs

class NQueen {
    fun dfsFunc(n: Int, currentRow: Int, currentCandidate: ArrayList<Int>) {
        if (n == currentRow) {
            println(currentCandidate)
            return
        } else {
            for (i in 0 until n) {
                if (isAvailable(i, currentCandidate)) { // 만족 조건
                    currentCandidate.add(i)
                    dfsFunc(n, currentRow + 1, currentCandidate)
                    currentCandidate.removeAt(currentCandidate.size - 1)
                }
            }
        }
    }

    private fun isAvailable(currentCol: Int, candidate: ArrayList<Int>): Boolean {
        val currentRow = candidate.size
        for (i in 0 until currentRow) {
            if (candidate[i] == currentCol || Math.abs(candidate[i] - currentCol) == abs(currentRow - i)) {
                return false
            }
        }
        return true
    }
}
fun main() {
    val nObject = NQueen()
    nObject.dfsFunc(4, 0, ArrayList())
}
