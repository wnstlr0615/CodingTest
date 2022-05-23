package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 현명한나이트18404 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int cx, cy; // 현재 위치
    public static int[][] enemys; // 적 좌표
    public static int[][] distances;
    public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    public static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
    private static void pro() {
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(cx);
        needVisited.add(cy);
        while(!needVisited.isEmpty()){
            int x = needVisited.poll();
            int y = needVisited.poll();

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX == cx && newY == cy)continue;
                if(newX >= 0 && newY >= 0 && newX <= N && newY <= N){
                    if(distances[newX][newY] == 0  || distances[x][y] + 1 < distances[newX][newY]){
                        distances[newX][newY] = distances[x][y] + 1;
                        needVisited.add(newX);
                        needVisited.add(newY);
                    }
                }
            }
        }
        for (int i = 0; i < M; i++) {
            int x = enemys[i][0];
            int y = enemys[i][1];
            System.out.print(distances[x][y] + " ");
        }
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        distances = new int[N + 1][N + 1];
        enemys = new int[M][2];
        split = br.readLine().split(" ");
        cx = Integer.parseInt(split[0]);
        cy = Integer.parseInt(split[1]);


        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            enemys[i][0] = Integer.parseInt(split[0]);
            enemys[i][1] = Integer.parseInt(split[1]);
        }
    }
}
