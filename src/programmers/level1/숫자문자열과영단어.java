package programmers.level1;

import java.util.List;
import java.util.stream.IntStream;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(solution("2three45sixseven"));
    }
    public static int solution(String s) {
        String[] numEng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numEng.length; i++) {
            s = s.replaceAll(numEng[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
