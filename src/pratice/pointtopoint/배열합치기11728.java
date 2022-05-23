package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열합치기11728 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] A, B;
    public static StringBuffer buffer = new StringBuffer();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int l1 = 0, l2=0;
        while(l1 < N && l2 < M){
            if(A[l1] <= B[l2]){
                buffer.append(A[l1++]).append(" ");
            }else {
                buffer.append(B[l2++]).append(" ");
            }
        }
        while(l1 < N){
            buffer.append(A[l1++]).append(" ");
        }

        while(l2 < M){
            buffer.append(B[l2++]).append(" ");
        }
        System.out.println(buffer);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        A = new int[N];

        M = Integer.parseInt(split[1]);
        B = new int[M];

        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(split[i]);
        }
    }
}
