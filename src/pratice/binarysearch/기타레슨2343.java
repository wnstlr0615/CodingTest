package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기타레슨2343 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int L = 0;
        int R = Integer.MAX_VALUE;
        int res = R;
        while(L <= R){
            int mid = (L + R) / 2;
            if(isPossible(mid)){
                res = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        System.out.println(res);
    }

    private static boolean isPossible(int mid) {
        int cnt = 0;
        long sum = 0;
        for (int i = 0; i < N ; i++) {
            if(A[i] > mid) return false;
            if(sum + A[i] <= mid){
                sum += A[i];
            }else{
                cnt++;
                sum = A[i];
            }
        }
        return cnt < M;
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
