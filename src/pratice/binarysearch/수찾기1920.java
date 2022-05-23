package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수찾기1920 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A, B;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            pro(B[i]);
        }
    }

    private static void pro(int num) {
        int L = 0 ;
        int R = A.length - 1;
        boolean check = false;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] == num){
                System.out.println(1);
                return;
            }else if(A[mid] < num){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(0);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] spilt = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(spilt[i]);
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        spilt = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(spilt[i]);
        }
    }
}
