package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의이동7562 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, T;
    public static int cx, cy; // 현재 위치
    public static int gx, gy; // 목적지
    public static int[][] distances;
    public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    public static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            pro();
        }


    }

    private static void pro() {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(cx);
        needVisited.add(cy);
        while(!needVisited.isEmpty()){
            int x = needVisited.poll();
            int y = needVisited.poll();

            if(distances[gx][gy] != 0 ){
                break;
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX == cx && newY == cy)continue;
                if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                    if(distances[newX][newY] == 0  || distances[x][y] + 1 < distances[newX][newY]){
                        distances[newX][newY] = distances[x][y] + 1;
                        needVisited.add(newX);
                        needVisited.add(newY);
                    }
                }
            }
        }

        System.out.println(distances[gx][gy]);
    }


    private static void input() throws IOException {
        N =Integer.parseInt(br.readLine());
        distances = new int[N][N];
        String[] split = br.readLine().split(" ");
        cx = Integer.parseInt(split[0]);
        cy = Integer.parseInt(split[1]);
        split = br.readLine().split(" ");
        gx = Integer.parseInt(split[0]);
        gy = Integer.parseInt(split[1]);
    }


}
