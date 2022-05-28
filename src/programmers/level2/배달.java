package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 배달 {
    static ArrayList<Edge>[] edges;
    static int[] distances;

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
    }
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        edges = new ArrayList[N + 1];
        distances = new int[N + 1];
        for (int i = 0; i <= N ; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            edges[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edges[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        answer = bfs(K);


        return answer;
    }

    private static int bfs(int k) {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(1);
        while(!needVisited.isEmpty()){
            Integer node = needVisited.poll();
            for (Edge edge : edges[node]) {
                if(edge.node != 1 && (distances[edge.node] == 0 || distances[node] + edge.weight < distances[edge.node])){
                    if(distances[node] + edge.weight > k)continue;
                    needVisited.add(edge.node);
                    distances[edge.node] = distances[node] + edge.weight;
                }
            }
        }
        for (int i = 0; i < distances.length; i++) {
            System.out.println(distances[i]);
        }

        return (int)Arrays.stream(distances).filter(num-> num > 0 && num <= k).count() + 1;
    }


}

class Edge{
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
