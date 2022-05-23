package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 세용액2473 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void pro() {
        int v1 = 0, v2 = 0, v3 = 0;
        long bestNum = Long.MAX_VALUE;
        for (int i = 0; i < N - 2 ; i++) {
            int target = -A[i];
            int L = i + 1;
            int R = N - 1 ;
            while(L < R){
                if(bestNum > Math.abs(-(long)target + A[L] + A[R])){
                    bestNum = Math.abs(-(long)target + A[L] + A[R]);
                    v1 = -target;
                    v2 = A[L];
                    v3 = A[R];
                }
                if(A[L] + A[R] > target)R--;
                else L++;
            }
        }
        System.out.println(v1 + " " + v2 + " " + v3);

    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
