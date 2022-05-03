package pratice.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class N과M15663 {
    public static int[] selected;
    public static int[] num, used;
    public static int N, M;
    public static StringBuffer buffer = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        num = new int[N + 1];
        used = new int[N + 1];
        selected = new int[M];
        split = reader.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            num[i + 1] = Integer.parseInt(split[i]);
        }
        Arrays.sort(num);
        function(0);
        System.out.println(buffer);
    }

    public static void function(int curIdx){
        if(curIdx >= M){
            for (int i = 0; i < curIdx; i++) {
                buffer.append(selected[i] + " ");
            }
            buffer.append("\n");
        }else{
            int lastNum = num[0];
            for (int i = 1; i <=N ; i++) {
                if( used[i] == 0 && lastNum != num[i]) {
                    lastNum = num[i];
                    selected[curIdx] = num[i]; used[i] = 1;
                    function(curIdx + 1);
                    selected[curIdx] = 0; used[i] = 0;
                }
            }
        }
    }
}
