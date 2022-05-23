package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {

    }
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0,-1, 0};
        int colSize = maps[0].length;
        int rowSize = maps.length;
        int[][] distances = new int[rowSize][colSize];
        Queue<Integer> needVisited = new LinkedList<>();

        needVisited.add(0);
        needVisited.add(0);
        distances[0][0] = 1;
        while(!needVisited.isEmpty()){
            int cx = needVisited.poll();
            int cy = needVisited.poll();
            if(distances[rowSize - 1][colSize - 1] != 0){
                answer = distances[rowSize - 1][colSize - 1];
                break;
            }
            for (int i = 0; i <4 ; i++) {
                int x = cx + dx[i];
                int y = cy + dy[i];
                if(x>=0 && y >=0 && x<rowSize && y<colSize){
                    if(maps[x][y] == 1){
                        if(distances[x][y] == 0 || distances[x][y] > distances[cx][cy] + 1){
                            distances[x][y] = distances[cx][cy] + 1;
                            needVisited.add(x);
                            needVisited.add(y);
                        }
                    }
                }
            }
        }
        return answer;
    }

}
