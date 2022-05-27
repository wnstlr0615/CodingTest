package programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {

        solution("[](){}");
    }
    public static int solution(String s) {
        int answer = 0;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < sLen; j++) {
                sb.append(s.charAt(j));
            }
            for (int j = 0; j <i  ; j++) {
                sb.append(s.charAt(j));
            }
            if(check(sb.toString()))answer++;
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(stack.isEmpty())stack.push(c);
            else{
                Character top = stack.peek();
                if(top == '{'){
                    if(c == '}')stack.pop();
                    else stack.push(c);
                }else if(top == '['){
                    if(c == ']')stack.pop();
                    else stack.push(c);

                }else if(top == '('){
                    if(c == ')')stack.pop();
                    else stack.push(c);
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
