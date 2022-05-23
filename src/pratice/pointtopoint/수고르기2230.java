package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기2230 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static long[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void pro() {
        long res = Long.MAX_VALUE;
        for (int L = 0, R = 1; L < N -1 ; L++) {
            while(R < N - 1 && A[R] - A[L] < M)++R;
            if(A[R] - A[L] >= M) res = Math.min(res, A[R] - A[L]);

        }
        System.out.println(res);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }
}
