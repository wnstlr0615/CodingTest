package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주전자 갯수 N < 10_000
// 친구들 K < 1_000_000
// 똑같은 양
//
public class 이상한술집13702 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
    private static void pro() {
        long L = 0;
        long R = Integer.MAX_VALUE;
        long k = L;
        while(L <= R){
            long mid = (L + R) / 2;
            if(isPossible(mid)){ // <
                k = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(k);
    }

    private static boolean isPossible(long mid) {
        long cnt = 0;
        if(mid == 0) return false;
        for (int i = 0; i < N; i++) {
            cnt += (A[i] / mid);
            if(cnt >= M){
                return true;
            }
        }
        return false;
    }
    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }
}
