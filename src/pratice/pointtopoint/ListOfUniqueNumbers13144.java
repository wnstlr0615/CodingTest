package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListOfUniqueNumbers13144 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] A;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int R = 0;
        long result = 0;
        for (int L = 0; L <N ; L++) {
            while(R < N && !check[A[R]]){
                check[A[R]] = true;
                R++;
            }
            result += (R - L);
            check[A[L]] = false;
        }
        System.out.println(result);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        check = new boolean[N + 1];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
    }
}
