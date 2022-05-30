package programmers.level2;

import java.util.stream.LongStream;

public class n2배열자르기 {
    public static void main(String[] args) {
        int[] solution = solution(4, 7, 14);
        for (int i : solution) {
            System.out.println(i);
        }
    }
    public static int[] solution(int n, long left, long right) {
        return LongStream.rangeClosed(left, right).mapToInt(num -> (int)(1 + Math.max(num / n, num % n))).toArray();
    }
}
