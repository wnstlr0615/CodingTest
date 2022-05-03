package pratice.backtraking;

//암호 만들기  L개의 알파벳 소문자로 구성
//(조건) 최소 한개의 모음 + 두개의 자음 으로 구성
// 정렬 : 사전식 정렬
// 문자의 종류는 C가지
//첫 째줄 암호 길이(L) , 문자 종류 (C)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 암호만들기1759 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuffer buffer = new StringBuffer();
    public static char[] c;
    public static char[] selected;
    public static boolean[] used;
    public static int L, C;
    public static void main(String[] args) throws IOException {
        input();
        function(0, -1);
        System.out.println(buffer);
    }

    private static void function(int curIdx, int lastword) {
        if(curIdx >= L){
            if(isPasswordAvailable(selected)){
                for (int i = 0; i < selected.length; i++) {
                    buffer.append(selected[i]);
                }
                buffer.append("\n");
            }
        }else{
            for (int i = 0; i < C; i++) {
                if(!used[i] && lastword < c[i]){
                    used[i] = true;
                    selected[curIdx] = c[i];
                    function(curIdx + 1, c[i]);
                    used[i] = false;
                }
            }
        }
    }

    private static boolean isPasswordAvailable(char[] selected) {
        int vowelCnt = 0;
        for (int i = 0; i < selected.length; i++) {
            switch(selected[i]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCnt++;
                default:
            }
        }
        return  vowelCnt >= 1 && (selected.length) - vowelCnt >= 2;
    }

    private static void input() throws IOException {
        String[] str = reader.readLine().split(" ");
        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        selected = new char[L];
        used = new boolean[C];
        c = reader.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(c);
    }
}
