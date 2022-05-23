package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기2667 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[][]A;
    public static boolean[][]visited;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        int cnt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i][j] != 0 && !visited[i][j]){
                    cnt++;
                    int total = bfs(new Point(i, j));
                    result.add(total);
                }
            }
        }
        System.out.println(cnt);
        result.sort(Comparator.comparingInt(a -> a));
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static int bfs(Point point) {
        Queue<Point> needVisited = new LinkedList<>();
        needVisited.add(point);
        int total = 0;
        while(!needVisited.isEmpty()){
            Point p = needVisited.poll();
            if(!visited[p.x][p.y]){
                visited[p.x][p.y] = true;
                total++;
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if(x >= 0 && y >= 0 && x < N && y < N){
                        if(!visited[x][y] && A[x][y] != 0){
                            needVisited.add(new Point(x, y));
                        }
                    }
                }
            }
        }
        return total;
    }
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j <N ; j++) {
                A[i][j] = chars[j] - '0';
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
