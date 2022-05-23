package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 연결요소의개수11724 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static HashMap<Integer, ArrayList<Integer>> edges;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> needVisited = new LinkedList<>();
        int cnt = 0;
        for (int i = 1; i <= N ; i++) {
            if(!visited.contains(i)){
                needVisited.add(i);
                cnt++;
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
            }
        }

        System.out.println(cnt);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        edges = new HashMap<>();
        for (int i = 1; i <= N ; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
    }
}
