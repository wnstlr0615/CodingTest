package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액2470 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }

    private static void pro() {
       int L = 0;
       int R = N - 1;
       int v1 = 0;
       int v2 = 0;
       int bestSum = Integer.MAX_VALUE;
       while(L < R){
           int sum = A[L] + A[R];
           if(Math.abs(sum) < bestSum){
               bestSum = Math.abs(sum);
               v1 = A[L];
               v2 = A[R];
           }
            if(sum > 0){
                R--;
            }else L++;
       }
        System.out.println(v1 + " " + v2);
    }

}
