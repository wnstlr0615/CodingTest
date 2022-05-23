package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자카드2_10816 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A, B;
    public static StringBuffer buffer = new StringBuffer();
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            buffer.append(upperBound(B[i]) - lowerBound(B[i])).append(" ");
        }
        System.out.println(buffer);
    }

    private static int upperBound(int num) {
        int L = 0;
        int R = N - 1;
        int idx = R + 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] > num){
                idx = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        return idx;
    }

    private static int lowerBound(int num) {
        int L = 0;
        int R = N - 1;
        int idx = R + 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] >= num){
                idx = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
       
        return idx;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(split[i]);
        }
    }
}
