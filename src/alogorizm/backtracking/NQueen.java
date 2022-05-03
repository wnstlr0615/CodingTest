package alogorizm.backtracking;

import java.util.ArrayList;

public class NQueen {
    public void dfsFunc(Integer n, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if(n.equals(currentRow)){
            System.out.println(currentCandidate);
            return;
        }else{
            for (int i = 0; i < n; i++) {
                if(isAvailable(i, currentCandidate)){//만족 조건
                    currentCandidate.add(i);
                    dfsFunc(n, currentRow + 1, currentCandidate);
                    currentCandidate.remove(currentCandidate.size() - 1);
                }
            }
        }
    }

    private boolean isAvailable(int currentCol, ArrayList<Integer> candidate) {
        Integer currentRow = candidate.size();
        for (int i = 0; i < currentRow; i++) {
            if(candidate.get(i).equals(currentCol) || Math.abs(candidate.get(i) - currentCol) == Math.abs(currentRow - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
