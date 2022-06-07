package pratice.graph.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계단오르기2579 {
    static Reader sc = new Reader();
    static int N;
    public static void main(String[] args){
        N = sc.nextInt();
        int[] arr = new int[N + 2];
        int[][] dp = new int[N + 2][2]; // [0] = 마지막에 1번 올라온 점수중 최대 , [1] 한번에 두번 오른 점수중 최대
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        dp[1][0] = arr[1];
        dp[1][1] = 0;
        dp[2][0] = dp[1][0] + arr[2];
        dp[2][1] = arr[2];

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));

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
