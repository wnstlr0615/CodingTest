package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 트리순회1991 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static HashMap<String, Node> nodes = new HashMap<>();
    public static String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        input();
        pro();


    }
    private static void pro() {
        preorder(nodes.get("A"));
        System.out.println();
        inorder(nodes.get("A"));
        System.out.println();
        postorder(nodes.get("A"));
    }

    private static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.name);
        preorder(node.leftNode);
        preorder(node.rightNode);
    }

    private static void inorder(Node node) {
        if(node == null) return;
        inorder(node.leftNode);
        System.out.print(node.name);
        inorder(node.rightNode);
    }

    private static void postorder(Node node) {
        if(node == null) return;
        postorder(node.leftNode);
        postorder(node.rightNode);
        System.out.print(node.name);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <N ; i++) {
            String node = String.valueOf(eng.charAt(i));
            nodes.put(node, new Node(node));
        }
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Node node = nodes.get(split[0]);
            if(!split[1].equals(".")){
                node.setLeftNode(nodes.get(split[1]));
            }
            if(!split[2].equals(".")){
                node.setRightNode(nodes.get(split[2]));
            }

        }
    }
    static class Node{
        String name;
        Node leftNode;
        Node rightNode;

        public Node(String name) {
            this.name = name;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }

}
