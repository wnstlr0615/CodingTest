package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램2623 {
    static Reader sc = new Reader();
    static StringBuffer sb = new StringBuffer();
    static int N, M, K;
    static ArrayList<Integer>[] edges;
    static int[] indeg;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> q =new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int x = q.poll();
            result.add(x);
            for (Integer y : edges[x]) {
                indeg[y]--;
                if(indeg[y] == 0){
                    q.add(y);
                }
            }
        }
        if(result.size() != N){
            System.out.println(0);
        }else{
            for (Integer node : result) {
                System.out.println(node);
            }
        }
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        edges = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 0; i <= N ; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M ; i++) {
            K = sc.nextInt();
            int node = sc.nextInt();
            for (int j = 0; j < K - 1; j++) {
                int nextNode = sc.nextInt();
                edges[node].add(nextNode);
                indeg[nextNode]++;
                node = nextNode;
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
