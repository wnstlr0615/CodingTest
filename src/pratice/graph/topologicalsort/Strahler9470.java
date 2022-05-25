package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Strahler9470 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int T;
    static int K, M, P;
    static ArrayList<Integer>[] edges;
    static int[] indeg;
    static int[] strahler;
    static int[] maxCnt;
    public static void main(String[] args){
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }

    private static void pro() {
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for (int i = 1; i <=M ; i++) {
            if(indeg[i] == 0){
                q.add(i);
                maxCnt[i] = strahler[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int x = q.poll();
            if(maxCnt[x] >=  2){
                strahler[x]++;
            }
            max = Math.max(max, strahler[x]);
            for (int y: edges[x]) {
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
                if(strahler[x]  == strahler[y]){
                    maxCnt[y]++;
                }else if(strahler[y] < strahler[x]){
                    strahler[y] = strahler[x];
                    maxCnt[y] = 1;
                }
            }
        }
        System.out.println(K +" " + max);
    }

    private static void input() {
        K = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        edges = new ArrayList[M + 1];
        indeg = new int[M + 1];
        strahler = new int[M + 1];
        maxCnt= new int[M + 1];
        for (int j = 0; j <= M; j++) {
            edges[j] = new ArrayList<>();
        }
        for (int j = 0; j < P; j++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[x].add(y);
            indeg[y]++;
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
