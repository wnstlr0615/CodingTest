package programmers.level1;

import java.util.stream.IntStream;

public class 나머지가1이되는수찾기 {
    public int solution(int n) {
        return IntStream.rangeClosed(1, n).filter(num -> (n % num) == 1).findFirst().getAsInt();
    }
}
