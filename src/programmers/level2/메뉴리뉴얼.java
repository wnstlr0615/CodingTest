package programmers.level2;

import java.util.*;

public class 메뉴리뉴얼 {
    static boolean[] eng = new boolean[26];
    static int[] max = new int[11];

    public static void main(String[] args) {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }
    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> menus = new LinkedHashMap<>();
        for (int size : course) {
            Arrays.stream(orders).forEach(order ->
                    fun(order, 0, size, menus, new StringBuffer())
            );
        }
        System.out.println(menus);
        for (int size : course) {
            for (String menu : menus.keySet()) {
                if(max[size] == 1)continue;
                if(menu.length() == size && max[size] == menus.get(menu)){
                    answer.add(menu);
                }
            }
        }
        answer.sort((s, t1) -> {
            int minLen = Math.min(s.length(), t1.length());
            for (int i = 0; i < minLen; i++) {
                char a = s.charAt(i);
                char b = t1.charAt(i);
                if(a == b)continue;
                return a-b;
            }
            return 0;
        });
        for (String s : answer) {
            System.out.println(s);
        }
        return answer.toArray(String[]::new);
    }

    private static void fun(String order, int cur, int size, HashMap<String, Integer> hashMap, StringBuffer sb) {
        if(cur >= size){
            String key = sb.toString();
            if(!hashMap.containsKey(key)){
                hashMap.put(key, 1);
            }else{
                int value = hashMap.get(key) + 1;
                hashMap.put(key, value);
                max[size] = Math.max(max[size], value);
            }

        }else{
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                if(cur > 0 && c - sb.charAt(cur - 1) <= 0 )continue;
                int idx = c - 'A';
                if(!eng[idx]){
                    eng[idx] = true;
                    sb.append(c);
                    fun(order, cur + 1, size, hashMap, sb);
                    sb.deleteCharAt(sb.length()- 1);
                    eng[idx] = false;
                }
            }
        }
    }
}
