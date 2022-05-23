package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두수의합3273 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, X;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void pro() {
        int res = 0;
        int L = 0;
        int R = N - 1;
        while(L<R){
            if(A[L] + A[R] < X)L++;
            else if(A[L] + A[R] > X)R--;
            else{
                res++;
                L++;
            }
        }
        System.out.println(res);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        X = Integer.parseInt(br.readLine());
    }
}
