package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 가장가까운공통조상3584 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int T, N, A, B;
    public static ArrayList<Integer>[] edges;
    public static int[] distances;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }
    private static void pro() {
        ArrayList<Integer> visitedA = dfs(A);
        ArrayList<Integer> visitedB = dfs(B);
        for (Integer parentNode : visitedA) {
            if(visitedB.contains(parentNode)){
                System.out.println(parentNode);
                break;
            }
        }
    }

    private static ArrayList<Integer> dfs(int start) {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        Stack<Integer> needVisited = new Stack<>();

        needVisited.add(start);
        while(!needVisited.isEmpty()){
            Integer node = needVisited.pop();
            visited.add(node);
            for (Integer parentNode : edges[node]) {
                needVisited.push(parentNode);
            }
        }
        return visited;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        distances = new int[N + 1];
        for (int j = 0; j <=N ; j++) {
            edges[j] = new ArrayList<Integer>();
        }
        String[] split;
        for (int j = 0; j < N - 1; j++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges[v].add(u);
        }
        split = br.readLine().split(" ");
        A = Integer.parseInt(split[0]);
        B = Integer.parseInt(split[1]);
    }
}
