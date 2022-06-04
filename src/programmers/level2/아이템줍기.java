package programmers.level2;


import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    public static void main(String[] args) {
        solution(new int[][]{{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}}, 1, 3 ,7, 8);
        solution(new int[][]{{1,1,8,4}, {2,2,4,9}, {3,6,9,8}, {6,3,7,7}}, 9, 7 ,6, 1);
        solution(new int[][]{{1,1,5,7}}, 1, 1 ,4, 7);

    }
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int maxLen = 101;
        int[][] arr = new int[maxLen][maxLen];
        int[][] distance = new int[maxLen][maxLen];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(characterX  * 2);
        needVisited.add(maxLen - 1 - characterY  * 2);
        distance[maxLen - 1  - characterY * 2][characterX * 2] = 1;
        setRoad(rectangle, arr);

        while(!needVisited.isEmpty()){
            Integer px = needVisited.poll();
            Integer py = needVisited.poll();
            if(distance[maxLen - 1 - itemY * 2][itemX * 2] != 0){
                answer = distance[maxLen - 1 - itemY * 2][itemX * 2] / 2;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = px + dx[i];
                int y = py + dy[i];
                if(x >= 0 && y >= 0 && x < maxLen && y < maxLen){
                    if(arr[y][x] == 1 ){
                        if(distance[y][x] == 0 || distance[py][px] + 1 < distance[y][x]){
                            needVisited.add(x);
                            needVisited.add(y);
                            distance[y][x] = distance[py][px] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

        return answer;
    }

    private static void setRoad(int[][] rectangle, int[][] arr) {
        for (int i = 1; i <=rectangle.length ; i++) {
            int x1 = rectangle[i-1][0] * 2;
            int y1 = (arr.length - 1) - rectangle[i-1][1] * 2;
            int x2 = rectangle[i-1][2] * 2;
            int y2 = (arr.length - 1) - rectangle[i-1][3] * 2;

            for (int j = y2; j <= y1 ; j++) {
                arr[j][x1] = 1;
                arr[j][x2] = 1;
            }
            for (int j = x1; j <= x2 ; j++) {
                arr[y1][j] = 1;
                arr[y2][j] = 1;
            }
        }

        for (int[] ints : rectangle) {
            int x1 = ints[0] * 2;
            int y1 = (arr.length - 1) - ints[1] * 2;
            int x2 = ints[2] * 2;
            int y2 = (arr.length - 1)  - ints[3] * 2;

            if(x2 - x1 > 1 && y1 - y2 > 1){
                for (int i = y2 + 1; i < y1 ; i++) {
                    for (int j = x1 +1 ; j < x2 ; j++) {
                        arr[i][j] = 0;
                    }
                }
            }

        }
    }
}
