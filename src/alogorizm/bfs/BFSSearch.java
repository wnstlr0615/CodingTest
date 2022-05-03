package alogorizm.bfs;

import java.util.*;

public class BFSSearch {
    public ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startNode){
        ArrayList<String> visited = new ArrayList<>();
        Queue<String> needVisited = new LinkedList<>();

        needVisited.add(startNode);

        while(needVisited.size() > 0){
            String node = needVisited.poll();
            if(!visited.contains(node)){
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }
        return visited;

    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        BFSSearch bfsSearch = new BFSSearch();
        ArrayList<String> visited = bfsSearch.dfs(graph, "A");
        System.out.println(visited);
    }
}
