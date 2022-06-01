package programmers.level2;

public class 가장긴팬린드롬 {
    public static void main(String[] args) {
        solution("abcde");
    }
    public static int solution(String s)
    {
        int sLen = s.length();
        int bestLen = 1;
        char[] chars = s.toCharArray();
        int len ;
        int idx;
        for (int i = 0; i < sLen; i++) {
             idx = 1;
             len = 0;
            while(i + 1 - idx >= 0 && i + idx < sLen){
                if(chars[i + 1 - idx] != chars[i + idx])break;
                len = idx * 2;
                idx++;
            }
            bestLen = Math.max(bestLen, len);
            idx = 1;
            len = 0;
            while(i - idx >= 0 && i + idx < sLen){
                if(chars[i - idx] != chars[i + idx])break;
                len = idx * 2 + 1;
                idx++;
            }
            bestLen = Math.max(bestLen, len);
        }
        System.out.println(bestLen);
        return bestLen;
    }


}
