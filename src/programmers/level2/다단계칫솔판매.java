package programmers.level2;

import java.util.HashMap;

public class 다단계칫솔판매 {
    static int[] money;
    static HashMap<String, Integer>  node = new HashMap<>();

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        solution(enroll, referral, seller, amount);
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int totalPeople = enroll.length ;
        for (int i = 0; i < totalPeople; i++) {
            node.put(enroll[i], i);
        }
        money = new int[totalPeople];

        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100, referral);
        }
        for (int num : money) {
            System.out.println(num);
        }
        return money;
    }

    private static void dfs(String seller, int profit, String[] referral) {
        if(seller.equals("-"))return;
        Integer x = node.get(seller);
        String parentNode = referral[x];
        int num = (int) (profit * 0.1);
        if(num < 1){
            money[x] = money[x] + profit;
        }else{
            money[x] = money[x] + profit - num;
            dfs(parentNode,  num, referral);
        }
    }
}
