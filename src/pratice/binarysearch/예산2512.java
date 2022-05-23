package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 예산2512 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        pro();

    }

    private static void pro() {
        int L = 0;
        int R = A[N - 1];
        int res = L;

        while(L <= R){
            int mid = (L + R) / 2;
            if(isAble(mid)){
                res = mid;
                L = mid + 1;
            }else{
                R = mid  - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean isAble(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(A[i] <= mid){
                sum += A[i];
            }else{
                sum += mid;
            }
        }
        return sum <= M;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        M = Integer.parseInt(br.readLine());
    }
}
