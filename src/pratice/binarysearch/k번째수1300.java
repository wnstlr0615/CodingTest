package pratice.binarysearch;

import java.util.Scanner;

public class k번째수1300 {
    public static int N;
    public static int M;
    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        long L = 1;
        long R = (long)N * N;
        long res = 0;
        while(L <= R){
            long mid = (L + R) / 2;
            if(isAble(mid)){
                res = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static boolean isAble(long candidate) {
        long sum = 0;
        for (int i = 1; i <= N ; i++) {
            sum += Math.min(N, candidate / i);
        }
        return sum >= M;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // 가운데 배열 삽입
    }
}
