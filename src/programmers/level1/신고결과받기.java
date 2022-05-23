package programmers.level1;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class 신고결과받기 {
    public static void main(String[] args) {
        //int[] solution = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        int[] solution = solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);

    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, HashSet<String>> banlist = new HashMap<String, HashSet<String>>();
        Map<String, Integer> banCnt = new LinkedHashMap<String, Integer>();
        Arrays.stream(id_list)
                        .forEach(name -> banCnt.put(name, 0));
        Arrays.stream(report)
                .forEach(str -> {
                    String[] user = str.split(" "); // [0] 신고자 [1] 신고 당하는 유저
                    if(!banlist.containsKey(user[1])){
                        banlist.put(user[1], new HashSet(List.of(user[0])));
                    }else{
                        banlist.get(user[1]).add(user[0]);
                    }
                });

        banlist.keySet().stream()
                .filter(name -> banlist.get(name).size() >= k)
                .forEach(name ->{
                    System.out.println(name);
                    banlist.get(name)
                            .forEach(user  -> banCnt.replace(user, banCnt.get(user) + 1));
                });
        ;
        answer = banCnt.values().stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
