package programmers.level2;

import java.util.ArrayList;

public class 피로도 {
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) {
        solution(80, new int[][]{{80,20}, {50,40}, {30,10}});
        System.out.println(max);
    }
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        backtracking(0, k, dungeons);
        return max;
    }

    private static void backtracking(int curIdx, int fatigue, int[][] dungeons) {
        max = Math.max(max, curIdx);
            for (int i = 0; i < dungeons.length; i++) {
                if(!visited[i] && fatigue >= dungeons[i][0]){
                    visited[i] = true;
                    backtracking(curIdx + 1, fatigue - dungeons[i][1], dungeons);
                    visited[i] = false;
                }
            }
        }
}
