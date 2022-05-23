package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 귀여운라이언15565 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, K;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int minLen = Integer.MAX_VALUE;
        int dollCnt = 0;
        for (int L = 0, R = 0; L < N ; L++) {
            while(R < N && L <= R && dollCnt < K){
              if(A[R] == 1){
                  dollCnt++;
              }
                R++;
            }
            if(dollCnt == K)minLen = Math.min(minLen, R - L);
            if(A[L] == 1){
                dollCnt--;
            }
        }
        System.out.println(minLen == Integer.MAX_VALUE ? -1 : minLen);
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
