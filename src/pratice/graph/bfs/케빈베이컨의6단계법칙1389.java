package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 케빈베이컨의6단계법칙1389 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] distances;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();


    public static void main(String[] args) throws IOException {
        input();
        pro();

    }

    private static void pro() {
        int bestNum = Integer.MAX_VALUE;
        int winner = 0;
        for (int i = 1; i <= N; i++) {
            int result = bfs(i);
            if(bestNum > result){
                bestNum = result;
                winner = i;
            }
        }
        System.out.println(winner);
    }

    private static int bfs(int startNode) {
        distances = new int[N + 1];
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(startNode);

        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
            for (Integer vertexNode : edges.get(node)) {
                if(vertexNode == startNode)continue;
                if(distances[vertexNode] == 0){
                    distances[vertexNode] = distances[node] + 1;
                    needVisited.add(vertexNode);
                }
            }
        }
        return Arrays.stream(distances).sum() ;
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
    }
}
