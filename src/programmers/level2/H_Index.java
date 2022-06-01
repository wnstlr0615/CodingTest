package programmers.level2;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        solution(new int[]{3, 0, 6, 1, 5});
    }
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int L = 0;
        int R = 10000;
        int h = L;
        while(L <= R){
            int mid = (L + R) / 2;
            if(check(citations, mid)){
                h = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(h);
        return h;
    }

    private static boolean check(int[] citations, int h) {
        int cnt = 0;
        for (int citation : citations) {
            if (citation >= h) cnt++;
        }
        return cnt >= h;
    }

}
