package pratice.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 연구소14502 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static int[][] A;
    public static int cnt = 0;
    public static boolean[][] visited;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static ArrayList<Point> blank;

    public static void main(String[] args) throws IOException {
        input();
        pro(0, new Point[3]);
        System.out.println(cnt);
    }

    private static void pro(int curIdx, Point[] p) {
        if(curIdx >= 3){
            boolean[][] visit = new boolean[N][M];
            Queue<Point> needVisited = new LinkedList<>();
            int zeroCnt = 0;
            for (int i = 0; i < 3; i++) {
                A[p[i].x][p[i].y] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(A[i][j] == 2){
                        needVisited.add(new Point(i, j));
                    }
                }
            }
            bfs(visit, needVisited);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(A[i][j] == 0 && !visit[i][j]){
                        zeroCnt++;
                    }
                }
            }
            cnt = Math.max(cnt, zeroCnt);
            for (int i = 0; i < 3; i++) {
                A[p[i].x][p[i].y] = 0;
            }
        }else{
            for (Point point : blank) {
                if (!visited[point.x][point.y]) {
                    visited[point.x][point.y] = true;
                    p[curIdx] = point;
                    pro(curIdx + 1, p);
                    visited[point.x][point.y] = false;
                }
            }
        }
    }

    private static void bfs(boolean[][] visit, Queue<Point> needVisited) {

        while(!needVisited.isEmpty()){
            Point p = needVisited.poll();
            if(!visit[p.x][p.y]){
                visit[p.x][p.y] = true;
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if(x >= 0 && x < N && y >= 0 && y < M){
                        if(A[x][y] != 1 && !visited[x][y]){
                            needVisited.add(new Point(x, y));
                        }
                    }
                }
            }
        }

    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N][M];
        blank = new ArrayList<>();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(split[j]);
                if(A[i][j] == 0){
                    blank.add(new Point(i, j));
                }
            }
        }
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
