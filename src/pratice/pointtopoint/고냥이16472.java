package pratice.pointtopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 고냥이16472 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] eng = new int[26];
    public static String str;
    public static int kind = 0;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int bestLen= 0 ;
        int strLen = str.length();
        for (int L = 0, R = 0; R < strLen; R++) {
            add(str.charAt(R));

            while (kind > N){
                erase(str.charAt(L++));
            }
            bestLen = Math.max(bestLen, R - L + 1);
        }
        System.out.println(bestLen);
    }

    private static void erase(char charAt) {
        eng[charAt - 'a']--;
        if(eng[charAt - 'a'] == 0){
            kind--;
        }
    }

    private static void add(char charAt) {
        eng[charAt - 'a']++;
        if(eng[charAt - 'a'] == 1){
            kind++;
        }
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
       str = br.readLine();
    }
}
