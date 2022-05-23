package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나무자르기2805 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] tress;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(tress);
        pro();

    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        tress = new int[N];
        split = br.readLine().split(" ");
        for (int i = 0; i <N ; i++) {
            tress[i] = Integer.parseInt(split[i]);
        }

    }

    private static void pro() {
        int L = 0;
        int R = tress[N - 1] + 1; // 나무 최대 높이

        int res = L;
        while(L <= R){
            int mid = (L + R) / 2;
            if(treeCutAble(mid)){
                res = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean treeCutAble(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(tress[i] > mid){
                sum += (tress[i] - mid);
            }
        }
        return sum >= M;
    }
}
