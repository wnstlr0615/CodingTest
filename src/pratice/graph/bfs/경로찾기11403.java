package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 경로찾기11403 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

    public static int[][] result;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(bfsSearch(i + 1, j + 1)){
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean bfsSearch(int x, int y) {
        Queue<Integer> needVisited = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        needVisited.addAll(edges.get(x));
        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
            if(node == y){
                return true;
            }
            if(!visited.contains(node)){
                visited.add(node);
                for (Integer vertexNode : edges.get(node)) {
                    if(!visited.contains(vertexNode)){
                        needVisited.add(vertexNode);
                    }
                }
            }
        }
        return false;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new int[N][N];
        for (int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(split[j - 1]) == 1){
                    edges.get(i).add(j);
                }
            }
        }
    }
}
