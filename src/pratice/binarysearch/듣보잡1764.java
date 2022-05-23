package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 듣보잡1764 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int cnt = 0;
    public static String[] A;
    public static String[] B;
    public static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < M; i++) {
            pro(B[i]);
        }
        System.out.println(cnt);
        System.out.println(buffer);
    }

    private static void pro(String name) {
        int L = 0;
        int R = N - 1;

        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid].equals(name)){
                cnt++;
                buffer.append(name).append("\n");
                return;
            }else if(A[mid].compareTo(name) < 0){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        A = new String[N];
        M = Integer.parseInt(split[1]);
        B = new String[M];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        for (int i = 0; i <M;  i++) {
            B[i] = br.readLine();
        }
    }
}
