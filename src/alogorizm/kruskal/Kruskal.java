package alogorizm.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    //root 노드 찾기
    private String find(String node){
        if(parent.get(node) != node){
            parent.put(node, find(parent.get(node)));
        }
        return  parent.get(node);
    }

    private void union(String nodeV, String nodeU){
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if(rank.get(root1) > rank.get(root2)){
            parent.put(root2, root1);
        }else{
            parent.put(root1, root2);
            if(rank.get(root1) == rank.get(root2)){
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    private void makeSet(String node){
        parent.put(node, node);
        rank.put(node, 0);
    }
    public ArrayList<Edge> kruskal(ArrayList<String> vertices, ArrayList<Edge> edges){
        ArrayList<Edge> mst = new ArrayList<>();
        Edge curEdge;

        for (int i = 0; i < vertices.size(); i++) {
            makeSet(vertices.get(i));
        }
        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            curEdge = edges.get(i);
            if(find(curEdge.nodeV) != find(curEdge.nodeU)){
                union(curEdge.nodeV, curEdge.nodeU);
                mst.add(curEdge);
            }
        }
        return mst;
    }


    public static void main(String[] args) {
        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        Kruskal kruskal = new Kruskal();
        ArrayList<Edge> mst = kruskal.kruskal(vetices, edges);

        mst.forEach(System.out::println);
    }
}
class Edge implements Comparable<Edge>{
    int weight;
    String nodeV;
    String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge edge) {
        return weight - edge.weight;
    }
}