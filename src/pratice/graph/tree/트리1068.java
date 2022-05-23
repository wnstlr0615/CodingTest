package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 트리1068 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;

    public static ArrayList<Integer>[] edges;
    public static int startNode, deleteNode;


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> needNode = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        int cnt = 0;
        if(startNode != deleteNode) {
            needNode.add(startNode);
            for (int i = 0; i < edges.length; i++) {
                edges[i].remove((Integer) deleteNode);
            }
            while (!needNode.isEmpty()) {
                Integer node = needNode.poll();
                if (!visited.contains(node)) {
                    visited.add(node);
                    if (edges[node].isEmpty()) cnt++;
                    for (Integer vertexNode : edges[node]) {
                        if (!visited.contains(vertexNode)) {
                            needNode.add(vertexNode);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i <N ; i++) {
            int node = Integer.parseInt(split[i]);
            if(node !=  -1){
                edges[node].add(i);
            }else{
                startNode = i;
            }
        }
        deleteNode = Integer.parseInt(br.readLine());
    }
}
