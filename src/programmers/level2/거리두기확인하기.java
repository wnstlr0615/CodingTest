package programmers.level2;
//P 는 응시자
//O 는 빈테이블
//X 는 파티션

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0,-1, 0};
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = pro(places[i]);
            System.out.println(answer[i]);
        }
        return answer;
    }
    private static int pro(String[] place) {
        int[][] arr = new int[5][5];
        setBox(place, arr);
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[i][j] == 1) {
                    if (bfsSearch(arr, new Point(i, j))) return 0;

                }
            }
        }
        return 1;
    }

    private static boolean bfsSearch(int[][] arr, Point start) {
        int[][] distances = new int[5][5];
        Queue<Point> needVisited = new LinkedList<>();
        needVisited.add(start);
        while(!needVisited.isEmpty()){
            Point p = needVisited.poll();
            if(arr[p.x][p.y] == 1 && distances[p.x][p.y]!=0){

                return true;
            }
            for (int i = 0; i <4 ; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x>=0 && y >=0 && x<5 && y<5){
                    if(x == start.x && y == start.y)continue;
                    if(distances[x][y] == 0 && distances[p.x][p.y] + 1 <= 2 && arr[x][y] != 2){
                        distances[x][y] = distances[p.x][p.y] + 1;
                        needVisited.add(new Point(x, y));
                    }
                }
            }
        }
        return false;
    }

    private static void setBox(String[] place, int[][] arr) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char c = place[i].charAt(j);
                if(c == 'P'){
                    arr[i][j] = 1;
                }else if(c == 'O'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
