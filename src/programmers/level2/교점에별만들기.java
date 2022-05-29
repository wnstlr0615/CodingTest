package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 교점에별만들기 {
    public static void main(String[] args) {
        solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
        solution(new int[][]{{0,1,-1},{1,0,-1},{1,0,1}});
    }
    public static String[] solution(int[][] line) {
        ArrayList<int[]> arr = new ArrayList<>();
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                if(A * D  - B * C == 0)continue;
                if((B*F -E*D) % (A*D-B*C) !=0
                        || (E*C -A*F) % (A*D-B*C) != 0) continue;
                int x = (int)((B*F -E*D)/(A*D-B*C));
                int y = (int)((E*C -A*F)/(A*D-B*C));
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                arr.add(new int[]{y,x});
            }
        }
        int w = maxX - minX + 1;
        int h = maxY - minY + 1;
        char[][] result = new char[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(result[i], '.');
        }
        for (int[] ints : arr) {
            int x = ints[1]  - minX ;
            int y = maxY - ints[0];
            result[y][x] = '*';
        }
        String[] answer = new String[h];
        for (int i = 0; i < result.length; i++) {
            answer[i] = new String(result[i]);
        }

        return answer;
    }
}
