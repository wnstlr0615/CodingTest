package pratice.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분수열의합1182 {
    public static int[] num;
    public static int N, M;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        input();
        function(0, 0);
        if (M == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    private static void function(int curIdx, int value) {
        if (curIdx >= N) {
            if (value == M) cnt++;
            return;
        } else {
            function(curIdx + 1, value + num[curIdx]);
            function(curIdx + 1, value);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        num = new int[N];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
    }
}
