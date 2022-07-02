package pratice.sort

fun main(){
    val N = readln().toInt()
    val students = mutableListOf<Student>()
    for(i in 0 until N){
        val (name, kor, eng, math) = readln().split(" ")
        students.add(Student(name, kor.toInt(), eng.toInt(), math.toInt()))
    }
    students.sort()
    students.forEach{println(it.name)}
}

data class Student(
    val name: String,
    val kor: Int,
    val eng: Int,
    val math: Int
) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return if (kor != other.kor) {
            other.kor - kor
        } else if (eng != other.eng) {
            eng - other.eng
        } else if (math != other.math) {
            other.math - math
        } else {
            name.compareTo(other.name)
        }
    }

}