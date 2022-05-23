package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 어두운굴다리17266 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] X;

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
        System.out.println(res);    }

    private static boolean isPossible(int h) {
        if(X[1] > h) return false;
        if(N - X[M] > h) return false;
        for (int i = 2; i <=M ; i++) {
            if(Math.abs(X[i] - X[i - 1]) > 2 * h){
                return false;
            }
        }
        return true;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        X = new int[M + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= M; i++) {
            X[i] =Integer.parseInt(split[i - 1]);
        }
    }
}
