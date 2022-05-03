package pratice.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N과M15649 {
    public static int[] selected;
    public static boolean[] used;
    public static int N, M;
    public static StringBuffer buffer = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        selected = new int[M + 1];
        used = new boolean[N + 1];
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
            for (int i = 1; i <=N ; i++) {
                if(!used[i]) {
                    selected[curIdx] = i;
                    used[i]=true;
                    function(curIdx + 1);
                    selected[curIdx] = 0;
                    used[i]=false;
                }
            }
        }
    }
}
