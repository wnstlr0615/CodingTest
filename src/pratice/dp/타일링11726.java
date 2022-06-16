package pratice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일링11726 {
    static Reader sc = new Reader();
    public static void main(String[] args){
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 1001; i++) {
            dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007 ;
        }
        System.out.println(dp[sc.nextInt()] % 10007);;
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
