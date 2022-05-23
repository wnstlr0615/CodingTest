package programmers.level1;

import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class 부족한금액계산하기 {
    public static void main(String[] args) {
        System.out.println(solution(3, 30, 4));
    }
    public static  long solution(int price, int money, int count) {
        return Math.max(LongStream.rangeClosed(1, count).reduce(-money, (a, b) -> a + price * b), 0);
    }
}
