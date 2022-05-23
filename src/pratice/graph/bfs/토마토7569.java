package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토7569 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int H, N, M;
    public static int[][][] box;
    public static int[][][] distances;
    public static int[][] dir ={
            {0, 1, 0}, //  상
            {0, -1, 0}, // 하
            {0, 0, 1}, //우
            {0, 0, -1},  // 좌
            {1, 0, 0}, // 위
            {-1, 0, 0} // 아래
    };
    public static Queue<Point> needVisited = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        pro();

    }

    private static void pro() {
        while(!needVisited.isEmpty()){
            Point p = needVisited.poll();
            for (int i = 0; i < 6; i++) {
                int x = p.x + dir[i][0];
                int y = p.y + dir[i][1];
                int z = p.z + dir[i][2];
                if(x >= 0 && y >= 0 && x < H && y < N && z >= 0 && z < M){
                    if(distances[x][y][z] == 0 && box[x][y][z] == 0){
                        needVisited.add(new Point(x, y, z));
                        distances[x][y][z] = distances[p.x][p.y][p.z] + 1;
                        box[x][y][z] = 1;
                    }
                }
            }
        }
        System.out.println(fun());
    }

    private static int fun() {
        int max = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0){
                        return - 1;
                    }
                    max =  Math.max(distances[i][j][k], max);
                }
            }
        }
        return max;
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        H = Integer.parseInt(split[2]);
        box = new int[H][N][M];
        distances = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                split = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(split[k]);
                    if(box[i][j][k] == 1){
                        needVisited.add(new Point(i, j, k));
                    }
                }
            }
        }
    }
    static class Point{
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
