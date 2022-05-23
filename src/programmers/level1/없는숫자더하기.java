package programmers.level1;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
