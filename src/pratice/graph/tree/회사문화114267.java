package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 회사문화114267 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static ArrayList<Integer>[] edges;
    public static int[] kind;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() throws IOException {
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int node = Integer.parseInt(split[0]);
            int score = Integer.parseInt(split[1]);
            kind[node] += score;
        }
        dfs(1);

        for (int i = 1; i <=N ; i++) {
            System.out.println(kind[i]);
        }


    }

    private static void dfs(int node) {
        for (Integer vertexNode : edges[node]) {
            kind[vertexNode] += kind[node];
            dfs(vertexNode);
        }
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        kind = new int[N+1];
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        split = br.readLine().split(" ");
        for (int i = 2; i <= N; i++) {
            int u = Integer.parseInt(split[i-1]);
            edges[u].add(i);
        }
    }
}

