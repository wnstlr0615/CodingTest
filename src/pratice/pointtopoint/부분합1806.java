package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분합1806 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, S;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int R = 0;
        int sum = 0;
        int ans =  N + 1;
        for (int L = 0; L < N ; L++) {
            while(R < N && sum < S){
                sum += A[R++];
            }
            if(sum >= S){
                ans = Math.min(ans, R - L);
            }
            sum -= A[L];
        }
        System.out.println(ans == N + 1 ? 0 : ans);
    }

    private static void input() throws IOException {
        String[] split =br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        A = new int[N];
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
