package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좋다1253 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void pro() {
        long cnt = 0 ;
        for (int i = 0; i < N; i++) {
            if(func(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean func(int idx) {
        int L = 0;
        int R = N - 1;
        int target = A[idx];

        while(L < R){
            if(L == idx) L++;
            else if(R == idx)R--;
            else{
                if(A[L] + A[R] > target) R--;
                else if(A[L] + A[R] < target) L++;
                else return true;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
