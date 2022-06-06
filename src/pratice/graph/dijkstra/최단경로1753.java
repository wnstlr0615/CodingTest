package pratice.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로1753 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int[] distances;
    static ArrayList<Edge>[] graph;

    static int N, M, start;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        for (int i = 1; i <= N ; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge edgeNode = pq.poll();
            if(distances[edgeNode.vertex] < edgeNode.weight)continue;
            for (Edge edge : graph[edgeNode.vertex]) {
                int distance = edgeNode.weight + edge.weight;
                if(distances[edge.vertex] > distance){
                    distances[edge.vertex] = distance;
                    pq.add(new Edge(edge.vertex, distance));
                }
            }
        }
        for (int i = 1; i <= N ; i++) {
            System.out.println(distances[i] != Integer.MAX_VALUE ? distances[i] : "INF");
        }
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();
        distances = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new Edge(end, weight));
        }
    }

    static class Edge implements Comparable<Edge>{
        public Integer vertex;
        public Integer weight;

        public Edge(Integer vertex, Integer weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }
    static class Reader{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            String next(){
                while(st == null || !st.hasMoreTokens()){
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return st.nextToken();
            }
            int nextInt(){
                return Integer.parseInt(next());
            }
            long nextLong(){
                return Long.parseLong(next());
            }
            String nextLine(){
                String str="";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return str;
            }
        }
}
