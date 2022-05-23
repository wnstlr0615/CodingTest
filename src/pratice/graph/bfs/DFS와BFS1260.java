package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS1260 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int V;
    public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();


    public static void main(String[] args) throws IOException {
        input();
        DfsSearch();
        System.out.println();
        BfsSearch();
    }

    private static void BfsSearch() {
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> needVisited = new LinkedList<>();

        needVisited.add(V);

        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
            if(!visited.contains(node)){
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }

        for (int i = 0; i < visited.size(); i++) {
            System.out.print(visited.get(i) + " ");
        }
        System.out.println();
    }

    private static void DfsSearch() {
        ArrayList<Integer> visited = new ArrayList<>();
        Stack<Integer> needVisited = new Stack<>();

        needVisited.add(V);

        while(!needVisited.isEmpty()){
            Integer node = needVisited.pop();
            if(!visited.contains(node)){
                visited.add(node);
                ArrayList<Integer> vertexNode = new ArrayList<>(graph.get(node));
                vertexNode.sort(Collections.reverseOrder());
                needVisited.addAll(vertexNode);
            }
        }
        for (Integer integer : visited) {
            System.out.print(integer + " ");
        }
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        V = Integer.parseInt(split[2]);
        for (int i = 1; i <=N ; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (Integer key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
    }
}
