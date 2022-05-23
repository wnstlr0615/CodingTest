package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두수의합3273 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, X;
    public static int[] A;
    public static int  cnt = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i <N ; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        X = Integer.parseInt(br.readLine());
        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            pro(X - A[i], i);
        }
        System.out.println(cnt);
    }

    private static void pro(int num, int idx) {
        int L = idx + 1;
        int R = N - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] == num){
                cnt++;
                return;
            }else if(A[mid] < num){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
    }
}
