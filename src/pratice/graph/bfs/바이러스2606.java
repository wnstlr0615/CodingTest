package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스2606 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> needVisited = new LinkedList<>();

        needVisited.add(1);

        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();

            if(!visited.contains(node)){
                visited.add(node);
                for (Integer vertexNode : edges.get(node)) {
                    if(!visited.contains(vertexNode)){
                        needVisited.add(vertexNode);
                    }
                }
            }
        }
        System.out.println(visited.size() - 1);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
    }
}
