package programmers;

import java.util.Arrays;
import java.util.stream.Stream;

public class 문자열압축 {
    public int solution(String s) {
        int bestLen = s.length();
        String beforeWord;
        for (int i = 1; i < s.length() ; i++) { // 문자열을 쪼개는 단위
            String word = s.substring(0, i);
            int cnt = 0;
            int idx = 0;
            while(idx < s.length()) {
                if(word.equals(s.substring(idx, idx+i))){
                    cnt++;
                }else{
                    word = s.substring(idx, idx + i);
                }
                idx += i;
            }
        }
        return bestLen;
    }

    private boolean isDividable(int len) {

        return false;
    }
}
