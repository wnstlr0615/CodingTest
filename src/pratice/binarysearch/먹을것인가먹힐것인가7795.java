package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 두 생명체 A , B
// A는 자기보다 작은 먹이를 먹을 수 있다
public class 먹을것인가먹힐것인가7795 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A, B;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String[] str;
        for (int i = 0; i < t; i++) {
            input();
            pro();
        }
    }
    private static void input() throws IOException {
        String[] str;
        str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        A = new int[N];
        M = Integer.parseInt(str[1]);
        B = new int[M];
        str = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            A[j]= Integer.parseInt(str[j]);
        }
        // B 배열 입력
        str = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
            B[j] = Integer.parseInt(str[j]);
        }
    }

    private static void pro() {
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += lowNumCount(B, 0, M - 1, A[i]);
        }
        System.out.println(ans);
    }
    private static int lowNumCount(int[] arr, int L, int R, int num) {

        int res = 0;
        while(L <= R){
            int mid = (L + R) / 2;
            if(arr[mid] < num){
                res = mid + 1;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return res;
    }

}
