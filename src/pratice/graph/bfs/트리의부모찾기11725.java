package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 트리의부모찾기11725 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] parent;
    public static boolean[] visited;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(1);

        while(!needVisited.isEmpty()){
            int node = needVisited.poll();
            if(!visited[node]){
                visited[node] = true;
                for (int vertexNode : edges.get(node)) {
                    if(!visited[vertexNode]){
                        needVisited.add(vertexNode);
                        parent[vertexNode] = node;
                    }
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] split = br.readLine().split(" ");
            int v = Integer.parseInt(split[0]);
            int u = Integer.parseInt(split[1]);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
    }
}
