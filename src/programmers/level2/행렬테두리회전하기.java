package programmers.level2;

import java.util.ArrayList;


public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
        solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] box = new int[rows][columns];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0, num = 1; i < rows; i++){
            for(int j = 0 ; j < columns; j++, num++){
                box[i][j] = num;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int cx = x1;
            int cy = y1;
            int min = box[cx - 1][cy - 1];
            int temp = box[cx - 1][cy - 1];
            for (int j = 0; j < 4; j++) {
                while (true) {
                    int px = cx + dx[j];
                    int py = cy + dy[j];
                    if (px > x2 || px < x1 || py > y2 || py < y1) {
                        break;
                    }
                    box[cx - 1][cy - 1] = box[px - 1][py - 1];
                    if (min > box[px - 1][py - 1]) {
                        min = box[px - 1][py - 1];
                    }
                    cx = px;
                    cy = py;
                }
            }
            box[cx-1][cy] = temp;
            answer.add(min);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }




}
