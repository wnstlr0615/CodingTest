package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//정렬하기
// 1. 국어 내림차순
// 2. 영어 오름 차순
// 3. 수학 내림차순
// 4. 이름 사전순
public class 국영수10825 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Student> students = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws IOException {
        input();
        Collections.sort(students);
        students.forEach(student -> System.out.println(student.name));
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] str;
        int kor;
        int eng;
        int math;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            kor = Integer.parseInt(str[1]);
            eng = Integer.parseInt(str[2]);
            math = Integer.parseInt(str[3]);
            students.add(new Student(str[0], kor, eng, math));
        }
    }
}

class Student implements Comparable<Student>{
    public String name;
    public int kor;
    public int eng;
    public int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        if(this.kor != student.kor) return student.kor - this.kor ;
        if(this.eng != student.eng) return  this.eng - student.eng;
        if(this.math != student.math) return student.math - this.math;
        return this.name.compareTo(student.name);
    }
}
