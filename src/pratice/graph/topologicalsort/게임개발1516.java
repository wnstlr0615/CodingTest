package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발1516 {
    static Reader sc = new Reader();
    static int N;
    static ArrayList<Integer>[] edges;
    static int[] buildTimes;
    static int[] totalTimes;
    static int[] indeg;
    public static void main(String[] args){
        input();
        pro();

    }

    private static void pro() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <indeg.length ; i++) {
            if(indeg[i] == 0){
                q.add(i);
                totalTimes[i] = buildTimes[i];
            }
        }

        while(!q.isEmpty()){
            Integer node = q.poll();
            for (Integer vertex : edges[node]) {
                indeg[vertex]--;
                if(indeg[vertex] == 0){
                    q.add(vertex);
                }
                totalTimes[vertex] = Math.max(totalTimes[vertex], totalTimes[node] + buildTimes[vertex]);
            }
        }
        for (int i = 1; i < totalTimes.length; i++) {
            System.out.println(totalTimes[i]);
        }
    }

    private static void input() {
        N = sc.nextInt();
        edges = new ArrayList[N + 1];
        buildTimes = new int[N + 1];
        totalTimes = new int[N + 1];;
        indeg = new int[N + 1];
        for (int i = 0; i <=N ; i++) {
            edges[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            buildTimes[i] = sc.nextInt(); // 건물 짓는데 걸리는 시간
            int node = sc.nextInt();
            while(node != -1){
                edges[node].add(i);
                indeg[i]++;
                node = sc.nextInt();
            }
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
