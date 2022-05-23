package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// . 빈필드
// # 울타리
// o 양
// v 늑낻
public class 양3184 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int R, C;
    public static int[][] A;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int sheepCnt = 0;
    public static int wolfCnt = 0;

    public static Queue<Integer> needVisited = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();

    }

    private static void pro() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(A[i][j] == 3 && !visited[i][j]){
                    needVisited.add(i);
                    needVisited.add(j);
                    bfs();
                }
            }
        }
        System.out.println(sheepCnt + " " + wolfCnt);
    }

    private static void bfs() {
         int o = 0, v = 0; // o는 양 v는 늑대 마리수
        while (!needVisited.isEmpty()) {
            int cx = needVisited.poll();
            int cy = needVisited.poll();

            if(!visited[cx][cy]){
                visited[cx][cy] = true;
                if(A[cx][cy] == 2){
                    o++;
                }
                if(A[cx][cy] == 3){
                    v++;
                }
                for (int i = 0; i < 4; i++) {
                    int x = cx + dx[i];
                    int y = cy + dy[i];
                    if(x >=0 && y >= 0 && x < R && y < C){
                        if(!visited[x][y]){
                            if(A[x][y] != 1 ){
                                needVisited.add(x);
                                needVisited.add(y);
                            }
                        }
                    }
                }
            }
        }
        if(v >= o){
            sheepCnt -= o;
        }else{
            wolfCnt -= v;
        }
    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        A = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(chars[j] == '#'){ //울타리
                    A[i][j] = 1;
                }else if(chars[j] == 'o'){ // 양
                    A[i][j] = 2;
                    sheepCnt++;
                }else if(chars[j] == 'v'){ // 늑대
                    A[i][j] = 3;
                    wolfCnt++;
                }else{
                    A[i][j] = 0;
                }
            }
        }


    }
}
