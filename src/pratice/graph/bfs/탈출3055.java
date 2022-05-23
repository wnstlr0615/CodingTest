package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// R 행 C 열
// S 고슴도치 위치
// D 비버 위치
// * 물이 차있는 지역(2)
// X 돌 (1)
// . 비어 있는 곳 (0)

public class 탈출3055 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int R, C;
    public static int[][] map;
    public static int[][] distances;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int bestDistance = 0;

     public static void main(String[] args) throws IOException {
         input();
         pro();
         System.out.println(bestDistance == 0 ? "KAKTUS" : bestDistance);
     }

     private static void pro() {
         Queue<Point> needVisited = new LinkedList<>();
         Queue<Point> floodNeedVisited = new LinkedList<>();
         for (int i = 0; i < R; i++) {
             for (int j = 0; j < C; j++) {
                 if(map[i][j] == 3){
                     needVisited.add(new Point(i, j));
                 }else if(map[i][j] == 2){
                     floodNeedVisited.add(new Point(i, j));
                 }
             }
         }

         while(!needVisited.isEmpty()){
             Point point = needVisited.peek();
             if(map[point.x][point.y] == 4){
                 bestDistance = distances[point.x][point.y];
                 break;
             }

             if(!floodNeedVisited.isEmpty()) {
                 ArrayList<Point> floodList = new ArrayList<>(floodNeedVisited);
                 floodNeedVisited.clear();
                 for (Point flood : floodList) {
                     for (int i = 0; i < 4; i++) {
                         int x = flood.x + dx[i];
                         int y = flood.y + dy[i];
                         if (x >= 0 && y >= 0 && x < R && y < C) {
                             if (map[x][y] == 0) {
                                 map[x][y] = 2;
                                 floodNeedVisited.add(new Point(x, y));
                             }
                         }
                     }
                 }
             }
             ArrayList<Point> nextVisit = new ArrayList<>(needVisited);
             needVisited.clear();
             for (Point p : nextVisit) {
                 for (int i = 0; i < 4; i++) {
                     int x = p.x + dx[i];
                     int y = p.y + dy[i];
                     if(x >= 0 && y >= 0  && x < R && y < C){
                         if(distances[x][y] == 0 || distances[x][y] >= distances[p.x][p.y] + 1){
                             if(map[x][y] == 4 || map[x][y] == 0){
                                 distances[x][y] = distances[p.x][p.y] + 1;
                                 needVisited.add(new Point(x, y));
                             }
                         }
                     }
                 }
             }
         }
     }

     private static void input() throws IOException {
         String[] split = br.readLine().split(" ");
         R = Integer.parseInt(split[0]);
         C = Integer.parseInt(split[1]);
         map = new int[R][C];
         distances = new int[R][C];
         for (int i = 0; i < R; i++) {
             char[] chars = br.readLine().toCharArray();
             for (int j = 0; j < C; j++) {
                 if(chars[j] == 'D'){ // 비버 굴
                     map[i][j] = 4;
                 }else if(chars[j] == 'S'){ // 고슴 도치
                     map[i][j] = 3;
                 }else if(chars[j] == '*'){ // 물이 차있는 지역
                     map[i][j] = 2;
                 }else if(chars[j] == 'X'){ // 돌
                     map[i][j] = 1;
                 }else{ // . 빈곳
                     map[i][j] = 0;
                 }
             }
         }
     }
     static class Point{
         int x;
         int y;
         public Point(int x, int y) {
             this.x = x;
             this.y = y;
         }
     }
 }
