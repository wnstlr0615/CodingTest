package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 나무탈출15900 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer>[] edges;
    public static int[] distances;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Stack<Integer> needVisited = new Stack<>();
        needVisited.add(1);
        int sum = 0;
        while(!needVisited.isEmpty()){
            Integer node = needVisited.pop();
            boolean check = false;
            for (int childNode : edges[node]) {
                if(distances[childNode] == 0 && childNode != 1){
                    check = true;
                    distances[childNode] = distances[node] + 1;
                    needVisited.add(childNode);
                }
            }
            if(!check){
                sum += distances[node];
            }
        }
        System.out.println(sum % 2 == 0 ? "No" : "Yes");
    }

    private static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        distances = new int[N + 1];
        for (int i = 0; i <= N ; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges[u].add(v);
            edges[v].add(u);
        }
    }
}
