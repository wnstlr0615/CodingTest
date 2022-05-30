package programmers.level2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N진수게임 {
    public static void main(String[] args) {
        solution(16, 16,2, 2 );
    }
    static String[] number = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public static String solution(int n, int t, int m, int p) {
        StringBuffer buffer = new StringBuffer();
        int len = 0;
        buffer.append(0);
        for (int i = 0; len <= t * (m+1) ; i++) {
            len = fun(i, n, buffer);
        }

        return IntStream.rangeClosed(1, t).mapToObj(num -> String.valueOf(buffer.charAt(m*(num-1) + p - 1))).collect(Collectors.joining());
    }
    private static int fun(int n, int k, StringBuffer buffer) {
        StringBuffer sb = new StringBuffer();
        int temp = n;
        while(temp > 0){
            sb.append(number[temp%k]);
            temp/=k;
        }
        buffer.append(sb.reverse());
        return buffer.length();
    }
}
