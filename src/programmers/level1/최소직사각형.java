package programmers.level1;

import java.util.Arrays;

public class 최소직사각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
    public static int solution(int[][] sizes) {
        int bestW = -1, bestH = -1;
        int w, h;
        for (int[] size : sizes) {
            w = Math.max(size[0], size[1]);
            h = Math.min(size[0], size[1]);
            bestW = Math.max(bestW, w);
            bestH = Math.max(bestH, h);
        }
        return bestW * bestH;
    }
}
