package pratice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막수11057 {
    static Reader sc = new Reader();
    static int N;
    public static void main(String[] args){
        N = sc.nextInt();
        int[][] dp = new int[N + 1][10];
        int sum = 0;
        for (int i = 0; i < 10 ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N ; i++) {
            for (int j = 0; j < 10 ; j++) {
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }
        for (int i = 0; i < 10 ; i++) {
            sum = (sum + dp[N][i]) % 10007;
        }
        System.out.println(sum);
    }
    static class Reader{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            String next(){
                while(st == null || !st.hasMoreTokens()){
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return st.nextToken();
            }
            int nextInt(){
                return Integer.parseInt(next());
            }
            long nextLong(){
                return Long.parseLong(next());
            }
            String nextLine(){
                String str="";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return str;
            }
        }
}
