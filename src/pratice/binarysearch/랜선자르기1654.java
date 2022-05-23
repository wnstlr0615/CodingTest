package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 랜선자르기1654 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int K, N;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();
    }

    private static void pro() {
        long L = 0;
        long R = Integer.MAX_VALUE;
        long res = L;
        while(L <= R){
            long mid = (L + R) / 2;
            if(cutAble(mid)){
                res = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean cutAble(long mid) {
        long cnt = 0;
        for (int i = 0; i < K ; i++) {
            cnt += (A[i] / mid);
            if(cnt >= N)return true;
        }
        return false;
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        K = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }
}
