package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 음양더하기 {
    public static void main(String[] args) {
        int solution = solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
        System.out.println(solution);
    }
    public static int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length).map(i -> signs[i] ? absolutes[i] : -absolutes[i]).sum();
    }
}
