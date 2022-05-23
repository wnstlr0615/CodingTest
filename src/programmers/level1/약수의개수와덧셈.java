package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 약수의개수와덧셈 {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }
    public static int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(num -> IntStream.rangeClosed(1, num).filter(div -> num % div == 0).count() % 2 == 0 ? num : -num).sum();
    }
}
