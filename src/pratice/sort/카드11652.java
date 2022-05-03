package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드11652 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static long[] num;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(num);
        System.out.println(function());
    }

    private static long function() {
        int maxCnt = 1;
        long minNum = num[0];
        int curCnt = 1;
        long curNum = num[0];

        for (int i = 1; i < num.length; i++) {
            if(num[i] == curNum){
                curCnt++;
            }else{
                curCnt = 1;
                curNum = num[i];
            }
            if(curCnt > maxCnt){
                maxCnt = curCnt;
                minNum = num[i];
            }
        }

        return minNum;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(br.readLine());;
        }
    }
}
