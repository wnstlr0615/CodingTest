package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 부동산다툼20364 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;

    public static boolean[] used;
    public static int[] area;
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 1; i <= M ; i++) {
            System.out.println(dfs(area[i]));
        }
    }
    private static int dfs(int start) {
        Stack<Integer> needVisited = new Stack<>();
        needVisited.push(start);
        int blockNum = 0;
        while(!needVisited.isEmpty()){
            Integer node = needVisited.pop();
            if(used[node]){
                blockNum = node;
            }
            if(node == 1){
                used[start] = true;
            }
            int parentNode = node / 2;
            if(parentNode >= 1){
                needVisited.add(parentNode);
            }
        }
        return blockNum;
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        used = new boolean[N + 2];
        area = new int[M + 2];
        for (int i = 1; i <= M; i++) {
            area[i] = Integer.parseInt(br.readLine());
        }

    }
}
