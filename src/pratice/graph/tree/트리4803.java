package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 트리4803 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M, edgeCnt, nodeCnt;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        for (int i = 1;  ; i++) {
            if(input()){
                pro(i);
            }else break;
        }
        System.out.println(sb);
    }

    private static void pro(int testCase) {
        // 싸이클 형성 했는지 확인
        // 간선의 개수가 n - 1
        Stack<Integer> needVisited = new Stack<>();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                needVisited.push(i);
                edgeCnt = 0;
                nodeCnt = 0;
                dfs(needVisited);
                if(edgeCnt == (nodeCnt - 1) * 2) cnt++;
            }
        }
        sb.append("Case ").append(testCase).append(": ");
        if(cnt == 0) sb.append("No trees.\n");
        else if(cnt == 1)sb.append("There is one tree.\n");
        else sb.append("A forest of ").append(cnt).append(" trees.\n");
    }

    private static void dfs(Stack<Integer> needVisited) {
        while(!needVisited.isEmpty()){
            Integer node = needVisited.pop();
            visited[node] = true;
            nodeCnt++;
            edgeCnt += edges[node].size();

            for (Integer vertexNode : edges[node]) {
                if(!visited[vertexNode]){
                    needVisited.add(vertexNode);
                }
            }
        }
    }

    private static boolean input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        visited = new boolean[N + 1];
        if(N == 0 && M == 0)return false;

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges[u].add(v);
            edges[v].add(u);
        }
        return true;
    }
}
