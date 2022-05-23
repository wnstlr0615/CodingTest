package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class 뉴스클러스터링1차 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
    }
    public static int solution(String str1, String str2) {
        Map<String, Integer> hash1 = new LinkedHashMap<>();
        Map<String, Integer> hash2 = new LinkedHashMap<>();
        Map<String, Integer> maxHash = new LinkedHashMap<>();
        Map<String, Integer> minHash = new LinkedHashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String divStr = str1.substring(i, i+2).toLowerCase();
            if(check(divStr)){ // 문자열 범위를 벗어나면
                continue;
            }
            if(!hash1.containsKey(divStr)){
                hash1.put(divStr, 1);
            }else{
                hash1.put(divStr, hash1.get(divStr) + 1);
            }

        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String divStr = str2.substring(i, i+2).toLowerCase();
            if(check(divStr)){ // 문자열 범위를 벗어나면
                continue;
            }
            if(!hash2.containsKey(divStr)){
                hash2.put(divStr, 1);
            }else{
                hash2.put(divStr, hash2.get(divStr) + 1);
            }
        }
        for (String str : hash1.keySet()) {
            if(hash2.containsKey(str)){
                Integer numA = hash1.get(str);
                Integer numB = hash2.get(str);
                minHash.put(str, Math.min(numB, numA));
                maxHash.put(str, Math.max(numB, numA));
            }else{
                maxHash.put(str, hash1.get(str));
            }
        }
        for (String str : hash2.keySet()) {
            if(!maxHash.containsKey(str)){
                maxHash.put(str, hash2.get(str));
            }
        }

        int minSize = minHash.keySet().stream().mapToInt(minHash::get).sum();
        int maxSize = maxHash.keySet().stream().mapToInt(maxHash::get).sum();
        return minSize == maxSize ? 65536 : (int)((minSize /(double) maxSize) * 65536) ;
    }

    private static boolean check(String divStr) {
        for (char c : divStr.toCharArray()) {
            if(c < 'a' || c > 'z'){
                return true;
            }
        }
        return false;
    }
}
