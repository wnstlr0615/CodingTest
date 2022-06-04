package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장난감조립2637 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static ArrayList<Edge>[] edges;
    static int[] indeg;
    static int[][] cnt;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <indeg.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
                cnt[i][i] = 1;
            }
        }
        while(!q.isEmpty()){
            Integer x = q.poll();
            for (Edge edge : edges[x]) {
                int y = edge.v;
                int w = edge.weight;
                indeg[y]--;
                for (int i = 1; i <=N ; i++) {
                    cnt[y][i] += cnt[x][i] * w;
                }
                if(indeg[y] == 0) q.add(y);

            }
        }
        for (int i = 1; i<=N;i++)
            if (cnt[N][i] != 0)
                System.out.println(i + " " + cnt[N][i]);
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        edges = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];
        for (int i = 1; i <= N ; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int K = sc.nextInt();
            edges[Y].add(new Edge(X, K));
            indeg[X]++;
        }
    }

    static class Edge{
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
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
