package pratice.graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 줄세우기2252 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static ArrayList<Integer>[] edges;
    public static int[] indeg;
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(indeg[i] == 0)queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(" ");
            for (Integer vertex : edges[x]) {
                indeg[vertex] --;
                if(indeg[vertex] == 0) queue.add(vertex);
            }
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        edges = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges[u].add(v);
            indeg[v]++;
        }
    }
}
