package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 트리와쿼리15681 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, R, Q;
    public static int[] childCnt;
    public static ArrayList<Integer>[] edges;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() throws IOException {
        dfs(R, -1);
        for (int i = 0; i < Q; i++) {
            int U =Integer.parseInt(br.readLine());
            System.out.println(childCnt[U]);
        }
    }

    private static void dfs(int x, int prev) {
        childCnt[x] = 1;
        for (int vertexNode : edges[x]) {
            if(vertexNode == prev)continue;
            dfs(vertexNode, x);
            childCnt[x] += childCnt[vertexNode];
        }
    }


    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        R = Integer.parseInt(split[1]);
        Q = Integer.parseInt(split[2]);
        edges = new ArrayList[N + 1];
        childCnt = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            split = br.readLine().split(" ");
            int u =Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges[u].add(v);
            edges[v].add(u);
        }
    }
}
