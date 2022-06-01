package programmers.level3;

import java.util.ArrayList;

public class N_Queen {
    public static void main(String[] args) {
        solution(4);
    }
    static int cnt = 0;
    public static int solution(int n) {
        ArrayList<Integer> candidate = new ArrayList<>();
        backtracking(0, n,candidate);
        System.out.println(cnt);
        return cnt;
    }

    private static void backtracking(int idx, int size, ArrayList<Integer> candidate) {
        if(idx >= size){
            System.out.println(candidate);
            cnt++;
        }else{
            for (int i = 0; i < size; i++) {
                if(checkMate(i, candidate)){
                    candidate.add(i);
                    backtracking(idx + 1, size, candidate);
                    candidate.remove(candidate.size() - 1);

                }
            }
        }
    }

    private static boolean checkMate(int curCol , ArrayList<Integer> candidate) {
        for (int i = 0; i < candidate.size(); i++) {
            if(candidate.get(i).equals(curCol)  || Math.abs(candidate.size() - i) == Math.abs(curCol - candidate.get(i))) return false;
        }
        return true;
    }
}
