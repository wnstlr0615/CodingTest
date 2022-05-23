package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합2_2003 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        input();
        pro();

    }
    //1. sum이 M 보다 작은 경우 A[R] 을 더한다.
    //2. sum이 m인경우 cnt + 1
    //3. sum이 M보다 큰경우 sum A[L]이 m보다 작을때 까지 뺀다.
    private static void pro() {
        // A[L] 부터 A[R] 까지의 합이 M이 되는 경우의 수
        int cnt = 0;
        int sum = 0;
        for (int L = 0, R = 0; L < N ; L++) {
            while(R < N && L <= R && sum <M){
                sum += A[R++];
            }
            if(sum == M){
                cnt++;
            }
            sum -= A[L];
        }
        System.out.println(cnt);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N];

        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
