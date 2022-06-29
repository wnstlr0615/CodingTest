package pratice.sort

fun main(){
    val N = readln().toInt()
    val words = linkedSetOf<String>()
    repeat(N){
        words.add(readln())
    }
    val sortedWords = words.toList().sortedWith(Comparator { a, b ->
        return@Comparator if (a.length != b.length) {
            a.length - b.length
        } else {
            a.compareTo(b)
        }
    }
    )

    sortedWords.forEach(::println)
}