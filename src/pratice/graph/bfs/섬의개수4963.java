package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 섬의개수4963 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int W, H;
    public static int[][] A;
    public static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    public static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        Queue<Integer> needVisited = new LinkedList<>();
        boolean[][] visited;
        while(true){
            int cnt =0;
            String[] split = br.readLine().split(" ");
            W = Integer.parseInt(split[0]);
            H = Integer.parseInt(split[1]);
            if(W == 0 && H == 0){
                break;
            }
            A = new int[H][W];
            visited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                split = br.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    A[i][j] = Integer.parseInt(split[j]);
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(!visited[i][j] && A[i][j] == 1){
                        needVisited.add(i);
                        needVisited.add(j);
                        cnt++;
                        while(!needVisited.isEmpty()){
                            int cx = needVisited.poll();
                            int cy = needVisited.poll();
                            if(!visited[cx][cy]){
                                visited[cx][cy] = true;

                                for (int k = 0; k < 8; k++) {
                                    int x = cx + dx[k];
                                    int y = cy + dy[k];
                                    if(x >= 0 && y >= 0 && x < H && y < W){
                                        if(!visited[x][y] && A[x][y] == 1){
                                            needVisited.add(x);
                                            needVisited.add(y);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);

        }
    }
}
