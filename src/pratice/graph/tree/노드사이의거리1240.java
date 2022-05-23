package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 노드사이의거리1240 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static ArrayList<Node>[] edges;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() throws IOException {
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            System.out.println(bfs(start, end));;
        }
    }

    private static int bfs(int start, int end) {
        int[] distances = new int[N + 1];
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(start);
        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
            if(node == end)break;

            for (Node vertexNode : edges[node]) {
                if(distances[vertexNode.vertex] == 0){
                    distances[vertexNode.vertex] = distances[node] + vertexNode.distance;
                    needVisited.add(vertexNode.vertex);
                }
            }
        }
        return distances[end];
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N ; i++) {
            edges[i] = new ArrayList<>();
        }
        M = Integer.parseInt(split[1]);
        for (int i = 0; i < N - 1; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);;
            int distance = Integer.parseInt(split[2]);
            edges[u].add(new Node(v, distance));
            edges[v].add(new Node(u, distance));
        }
    }

    static class Node{
        public int vertex;
        public int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
