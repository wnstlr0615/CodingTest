package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업2056 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static ArrayList<Integer>[] edges;
    static int[] indeg;
    static int[] times;
    static int[] sumTimes;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        for (int i = 1; i < indeg.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
                sumTimes[i] = times[i];
            }
        }

        while(!q.isEmpty()){
            Integer x = q.poll();
            for (int y : edges[x]) {
                indeg[y]--;
                if(indeg[y] == 0){
                    q.add(y);
                }
                sumTimes[y] = Math.max(sumTimes[y], sumTimes[x] +  times[y]);
            }
        }

        for (int i = 1; i < sumTimes.length ; i++) {
            res = Math.max(res, sumTimes[i]);
        }
        System.out.println(res);
    }

    private static void input() {
        N = sc.nextInt();
        edges = new ArrayList[N + 1];
        indeg = new int[N + 1];
        times = new int[N + 1];
        sumTimes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            times[i] = sc.nextInt();
            M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                int node = sc.nextInt();
                edges[node].add(i);
                indeg[i]++;
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
