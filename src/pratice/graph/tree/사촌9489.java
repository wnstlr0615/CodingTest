package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사촌9489 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, K;
    public static int[] nodes;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        while(input()) {
           pro();
        }

    }
    private static void pro() {
        int cnt = 0;
        parent[0] = -1;
        parent[1] = 0;
        int last = 1;
        for (int i = 2; i <=N; i++, last++) {
            for (;  i<= N ; i++) {
                parent[i] = last;
                if(i < N && nodes[i] + 1 != nodes[i + 1]){
                    break;
                }
            }
        }
        int kIdx = 0;
        for (int i = 1; i <= N ; i++) if(nodes[i] == K) kIdx = i;
        for (int i = 1; i <=N ; i++) {
            if(parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        if(N == 0 && K == 0) return false;
        nodes = new int[N + 1];
        parent = new int[N + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            nodes[i] = Integer.parseInt(split[i - 1]);
        }
        return true;
    }
}
