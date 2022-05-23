package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치2110 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, C;
    public static int[] distances;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(distances);

        int L = 1;
        int R = distances[N-1] - distances[0]; // 최대 거리
        int res = L;
        while(L <= R){
            int mid = (L + R) / 2;
            if(canSetUp(mid)){
                res = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean canSetUp(int mid) {
        int cnt = 1;
        int last = distances[0];
        for (int i = 1; i < N; i++) {
           if(distances[i] - last >= mid){
               cnt++;
               last = distances[i];
           }
            if(cnt >= C){
                return true;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        distances = new int[N];
        for (int i = 0; i < N; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }
    }
}
