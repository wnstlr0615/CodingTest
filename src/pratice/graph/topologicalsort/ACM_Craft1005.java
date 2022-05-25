package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft1005 {
    static Reader reader = new Reader();
    static StringBuffer sb = new StringBuffer();

    public static int T, N, K, W;
    public static int[] buildTime;
    public static int[] time;
    public static ArrayList<Integer>[] edges;
    public static int[] indeg;
    public static void main(String[] args) {
        T = reader.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
        System.out.println(sb);
    }

    private static void pro() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <=N ; i++) {
            if(indeg[i] == 0 ) {
                queue.add(i);
                time[i] =buildTime[i];
            }
        }
        while(!queue.isEmpty()){
            Integer x = queue.poll();
            if(x == W) break;
            for (int y : edges[x]) {
                indeg[y]--;
                if(indeg[y] == 0)queue.add(y);
                time[y] = Math.max(time[y], time[x] + buildTime[y]);
            }
        }

        sb.append(time[W]).append("\n");
    }

    private static void input() {
        N = reader.nextInt();
        K = reader.nextInt();
        buildTime = new int[N + 1];
        indeg = new int[N + 1];
        time = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            buildTime[i] = reader.nextInt();
        }
        for (int j = 0; j < K; j++) {
            int x = reader.nextInt();
            int y =reader.nextInt();
            edges[x].add(y);
            indeg[y]++;
        }
        W = reader.nextInt();
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

