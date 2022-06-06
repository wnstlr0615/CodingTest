package alogorizm.bfs;

import java.util.*;

public class 다익스트라구현연습 {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
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
     static class Dijkstra{
        public HashMap<String, Integer> dijkstra(HashMap<String, ArrayList<Edge>> graph, String start){
            HashMap<String, Integer> distances = new HashMap<>();
            graph.keySet().stream()
                    .forEach(key -> distances.put(key, Integer.MAX_VALUE));
            distances.put(start, 0);
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(start, 0));

            while(!pq.isEmpty()){
                Edge edgeNode = pq.poll();
                String curNode =  edgeNode.vertex;
                int curDistance = edgeNode.distance;
                if(curDistance > distances.get(curNode))continue;
                for (Edge edge : graph.get(curNode)) {
                    int distance = edge.distance + distances.get(curNode);
                    if(distances.get(edge.vertex) > distance){
                        distances.put(edge.vertex, distance);
                        pq.add(new Edge(edge.vertex, distance));
                    }
                }
            }
            return distances;
        }
    }

    static class Edge implements Comparable<Edge> {
        public int distance;
        public String vertex;

        public Edge(String vertex, int distance) {
            this.distance = distance;
            this.vertex = vertex;
        }

        // System.out.println() 으로 객체 자체 출력시,
        public String toString() {
            return "vertex: " + this.vertex + ", distance: " + this.distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }
}


