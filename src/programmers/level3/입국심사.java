package programmers.level3;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        System.out.println(solution( 2, new int[]{3, 7}));
        //System.out.println(solution( 8, new int[]{5, 7,12}));
        //System.out.println(isOk(21, 8, new int[]{5, 7,12}));
        System.out.println(solution(3, new int[]{1, 99, 99}));
    }

    public static long solution(int n, int[] times) {
        long  L = 0;
        long  R = Long.MAX_VALUE;
        long res = 0;
        Arrays.sort(times);
        while(L <= R){
            long mid = ((L + R) / 2);
            if(isOk(mid, n, times)){
                res = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return res;
    }

    private static boolean isOk(long second, int n, int[] times) {
        long sum = 0;
        for (int time : times) {
            sum += (second / time);
            if (sum >= n) return true;
        }
        return false;
    }
}
