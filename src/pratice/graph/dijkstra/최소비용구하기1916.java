package pratice.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기1916 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static int[] distances;
    static int start, end;
    static ArrayList<Edge>[] graph;
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
            if(edgeNode.weight > distances[edgeNode.vertex])continue;
            for (Edge edge : graph[edgeNode.vertex]) {
                int distance = edge.weight + edgeNode.weight;
                if(distances[edge.vertex] > distance){
                    distances[edge.vertex] = distance;
                    pq.add(new Edge(edge.vertex, distance));
                }
            }
        }
        System.out.println(distances[end]);
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        distances = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from].add(new Edge(to, weight));
        }
        start = sc.nextInt();
        end = sc.nextInt();
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
