package programmers.level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{97, 96, 99, 98, 95, 94}, new int[]{31, 10, 45, 1, 6, 19});
        for (int num : answer) {
            System.out.println(num);
        }
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zeroCnt = (int) Arrays.stream(lottos).filter(num -> num == 0 ).count();
        int collectCnt = (int) Arrays.stream(win_nums).filter(num -> Arrays.binarySearch(lottos, num) > 0 ).count();
        int bestGrade = Math.min(6, 7 - (collectCnt + zeroCnt));
        int worstGrade = Math.min(6, 7 - collectCnt);
        return new int[]{bestGrade, worstGrade};
    }
}
