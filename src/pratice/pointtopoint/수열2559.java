package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수열2559 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, K;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        long sum = 0;
        long maxValue = Long.MIN_VALUE;
        int cnt = 0;
        for (int L = 0, R = 0; L <= N - K ; L++) {
            while(R < N && L <= R && cnt < K){
                sum += A[R++];
                cnt++;
            }
            cnt--;
            maxValue = Math.max(maxValue, sum);
            sum -= A[L];
        }
        System.out.println(maxValue);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        A = new int[N];
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
