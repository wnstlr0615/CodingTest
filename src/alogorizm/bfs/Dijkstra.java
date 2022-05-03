package alogorizm.bfs;

import java.util.*;

public class Dijkstra {
    public HashMap<String,Integer> dijkstra(HashMap<String, ArrayList<Edge>> graph, String start){
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        graph.keySet()
                .forEach(
                        key -> distances.put(key, Integer.MAX_VALUE)
                );

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        distances.put(start, 0);
        priorityQueue.add(new Edge(start, 0));
        while(priorityQueue.size() > 0){
            Edge edgeNode = priorityQueue.poll();
            int curDistance = edgeNode.distance;
            String curNode = edgeNode.vertex;

            if(distances.get(curNode) < curDistance){
                continue;
            }
            ArrayList<Edge> edges = graph.get(curNode);
            for (int i = 0; i < edges.size(); i++) {
                Edge adjacentNode = edges.get(i);
                int distance = adjacentNode.distance + curDistance;
                String adjacent = adjacentNode.vertex;
                if(distances.get(adjacent) > distance){
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(adjacent, distance));
                }
            }

        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<>(List.of(new Edge("F", 1))));
        graph.put("F", new ArrayList<>(List.of(new Edge("A", 5))));

        Dijkstra dijkstra = new Dijkstra();
        HashMap<String, Integer> result = dijkstra.dijkstra(graph, "A");
        System.out.println(result);
    }
}

class Edge implements Comparable<Edge>{
    String vertex;
    int distance;

    public Edge(String vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}
