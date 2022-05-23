package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농배추1012 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int T, N, M, K;
    public static int [][] A;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Queue<Integer> needVisited ;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }

    private static void pro() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1 && !visited[i][j]){
                    needVisited.add(i);
                    needVisited.add(j);
                    bfs();
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs() {
        while(!needVisited.isEmpty()){
            int cx = needVisited.poll();
            int cy = needVisited.poll();
            if(!visited[cx][cy]){
                visited[cx][cy] = true;
                for (int i = 0; i < 4; i++) {
                    int x = cx + dx[i];
                    int y = cy + dy[i];
                    if(x >= 0 && y >= 0 && x < N && y < M){
                        if(A[x][y] == 1 && !visited[x][y]){
                            needVisited.add(x);
                            needVisited.add(y);
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
        K = Integer.parseInt(split[2]);
        A = new int[N][M];
        visited = new boolean[N][M];
        needVisited = new LinkedList<>();
        for (int j = 0; j < K; j++) {
            split = br.readLine().split(" ");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            A[r][c] = 1;
        }
    }
}
