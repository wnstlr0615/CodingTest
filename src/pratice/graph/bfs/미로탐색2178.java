package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색2178 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[][] A;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] distances;

    public static void main(String[] args) throws IOException {
        input();
        dfs(new Point(0, 0));

    }



    private static void dfs(Point point) {
        Queue<Point> needVisited = new LinkedList<>();
        needVisited.add(point);
        distances[point.x][point.y] = 1;
        while(!needVisited.isEmpty()){
            Point p = needVisited.poll();
            if(distances[N - 1][M - 1] != 0 ){
                break;
            }
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if(x >=0 && y >= 0 && x < N && y < M){
                        if(A[x][y] == 1 && (distances[x][y] == 0 || distances[p.x][p.y] + 1 < distances[x][y])){
                            needVisited.add(new Point(x, y));
                            distances[x][y] = distances[p.x][p.y] + 1;
                        }
                    }
                }
        }
        System.out.println(distances[N - 1][M - 1]);
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N][M];
        distances = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                A[i][j] = chars[j] - '0';
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

