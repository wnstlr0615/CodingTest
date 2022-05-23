package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식5567 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public static int[] distances;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> needVisited = new LinkedList<>();

        needVisited.add(1);
        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
                for (Integer vertexNode : edges.get(node)) {
                    if(distances[vertexNode] == 0 && vertexNode != 1  && distances[node] < 2){
                        distances[vertexNode] = distances[node] + 1;
                        needVisited.add(vertexNode);
                    }
                }
            }
        System.out.println(Arrays.stream(distances).filter(num -> num != 0).count());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distances = new int[N+1];
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
