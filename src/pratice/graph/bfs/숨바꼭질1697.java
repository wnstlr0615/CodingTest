package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질1697 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[] distances;
    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        distances = new int[100001];
        bfs();

    }

    private static void bfs() {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(N);
        while(!needVisited.isEmpty()){
            Integer x = needVisited.poll();
            if(distances[M] != 0 ){
                break;
            }
            if(x + 1 <  100001 && x + 1 != N){
                if(distances[x + 1] > distances[x] + 1 || distances[x + 1] == 0){
                    needVisited.add(x + 1);
                    distances[x + 1] = distances[x] + 1;
                }
            }
            if(x - 1 >= 0  && x - 1 != N){
                if(distances[x - 1] > distances[x] + 1 || distances[x - 1] == 0){
                    needVisited.add(x - 1);
                    distances[x - 1] = distances[x] + 1;
                }
            }
            if(x * 2  < 100001  && x*2 != N) {
                if(distances[x * 2] > distances[x] + 1 || distances[x * 2] == 0){
                    needVisited.add(x * 2);
                    distances[x * 2] = distances[x] + 1;
                }
            }
        }
        System.out.println(distances[M]);
    }
}
