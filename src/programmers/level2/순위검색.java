package programmers.level2;

import java.util.*;

public class 순위검색 {

     static String[][]  personInfo = {
            {"java", "cpp", "python", "-"},
            {"backend", "frontend", "-"},
            {"junior", "senior", "-"},
            {"chicken", "pizza", "-"}
    };
    static HashMap<String, ArrayList<Integer>> personMap = new LinkedHashMap<>();
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);


    }

    private static void bfs(String[][] arrInfo, int curIdx, int size, StringBuffer sb, ArrayList<String> keyList) {
        if(curIdx >= size){
            keyList.add(sb.toString());
        }else{
            for (int i = 0; i <arrInfo[curIdx].length ; i++) {
                sb.append(arrInfo[curIdx][i]).append(" ");
                bfs(arrInfo, curIdx + 1, size, sb, keyList);
                sb.delete(sb.lastIndexOf(arrInfo[curIdx][i]), sb.length());
            }
        }
    }

    public static int[] solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> keyList = new ArrayList<>();
        bfs(personInfo, 0, 4, new StringBuffer(), keyList);
        for (String key : keyList) {
            personMap.put(key, new ArrayList<>());
        }
        for (String str : info) {
            int idx = str.lastIndexOf(" ");
            String key = str.substring(0, idx);
            Integer score = Integer.parseInt(str.substring(idx + 1));
            fun(key, score);
        }
        for (String key : personMap.keySet()) {
            Collections.sort(personMap.get(key));
        }
        for (String str : query) {
            str = str.replaceAll(" and", "");
            int idx = str.lastIndexOf(" ");
            String key = str.substring(0, idx + 1);
            Integer score = Integer.parseInt(str.substring(idx + 1));
            ArrayList<Integer> scores = personMap.get(key);
            answer.add(lowerBound(scores, score));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Integer lowerBound(ArrayList<Integer> scores, Integer score) {
        int L = 0;
        int R = scores.size() - 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(scores.get(mid) < score){
                L = mid + 1 ;
            }else{
                R = mid - 1;
            }
        }
        return scores.size() - L;
    }

    private static void fun(String keyStr, Integer score) {
        String[] split = keyStr.split(" ");
        String[][] strArrInfo = {
                {split[0], "-"},
                {split[1], "-"},
                {split[2], "-"},
                {split[3], "-"},
        };
        ArrayList<String> keyList = new ArrayList<>();
        bfs(strArrInfo, 0, 4, new StringBuffer(), keyList);
        for (String key : keyList) {
            personMap.get(key).add(score);
        }
    }


}
