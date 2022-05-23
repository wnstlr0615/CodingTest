package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public static void main(String[] args) {
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public static String[] solution(String[] record) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();
        for(String message : record){
            String[] split = message.split(" ");
            String com = split[0];
            String username = split[1];

            if(com.equals("Enter")){
                if(!userInfo.containsKey(username) || !userInfo.get(username).equals(split[2])){
                    userInfo.put(username, split[2]);
                }
                ans.add(username + "|님이 들어왔습니다.");
            }else if(com.equals("Leave")){
                ans.add(username+ "|님이 나갔습니다.");
            }else{ // Change
                userInfo.put(username, split[2]);
            }
        }
        String[] answer = ans.stream()
                .map(eventMessage -> {
                    int idx = eventMessage.indexOf("|");
                    String name = eventMessage.substring(0, idx);
                    return userInfo.get(name) + eventMessage.substring(idx + 1);
                }).toArray(String[]::new);

        return answer;
    }
}
