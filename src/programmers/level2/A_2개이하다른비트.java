package programmers.level2;

import java.util.Arrays;

public class A_2개이하다른비트 {
    public static void main(String[] args) {
        long[] solution = solution(new long[]{2, 10, 7});
        for (long l : solution) {
            System.out.println(l);
        }
    }

    public static long[] solution(long[] numbers) {
        return Arrays.stream(numbers).map(
                number -> {
                    long num = 1;
                    if((number | 1) != number) return number + 1;
                    for (num = 1; number >= num; num = num<<1) {
                        if ((number | num) != number) break;
                    }
                    return number + (num >>1);
                }).toArray();
    }
}
