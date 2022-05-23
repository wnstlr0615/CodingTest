package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 촌수계산2644 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int M;
    public static int a, b;
    public static int[] distances;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(a);

        while(!needVisited.isEmpty()){
            int node = needVisited.poll();
            if(distances[b] != 0){
                break;
            }
            for (Integer vertexNode : edges.get(node)) {
                if(distances[vertexNode] == 0){
                    distances[vertexNode] = distances[node] + 1;
                    needVisited.add(vertexNode);
                }
            }
        }
        System.out.println(distances[b] != 0 ? distances[b] : -1);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        distances = new int[N + 1];
        String[] split = br.readLine().split(" ");
        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);
        M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int v = Integer.parseInt(split[0]);
            int u = Integer.parseInt(split[1]);

            edges.get(v).add(u);
            edges.get(u).add(v);
        }
    }
}
