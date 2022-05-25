package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 영우는사기꾼14676 {
    static Reader sc = new Reader();
    static int N, M, K;
    static int[] indeg, cnt, building;
    static ArrayList<Integer>[] edges;
    public static void main(String[] args){
        input();
        pro();
    }

    private static void pro() {
        boolean check = false;

        for (int i = 0; i < K; i++) {
            int c = sc.nextInt();
            int x = sc.nextInt();
            if(c == 1){
                if(building[x] < indeg[x]){
                    check = true;
                }
                cnt[x]++;
                if(cnt[x] == 1){
                    for (Integer y : edges[x]) {
                        building[y]++;
                    }
                }
            }else {
                if(cnt[x] == 0) {
                    check = true;
                }
                cnt[x]--;
                if(cnt[x] == 0){
                    for (Integer y : edges[x]) {
                        building[y]--;
                    }
                }
            }
        }
        if (check) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");
    }

    private static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        edges = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1];
        building = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y =sc.nextInt();
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
