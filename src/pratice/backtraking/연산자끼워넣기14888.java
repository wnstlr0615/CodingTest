package pratice.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연산자끼워넣기14888 {
    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static int[] num;
    public static int[] selectedOperator;
    public static int[] operatorCnt = new int[4];
    static int N;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        input();
        function(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void function(int curIdx) {
        if(curIdx >= N - 1){
            cnt++;
            int result = result();
            if(result > max) max = result;
            if(result < min) min = result;
        }else{
            for (int i = 0; i < 4; i++) {
                if(operatorCnt[i] > 0){
                    operatorCnt[i]--;
                    selectedOperator[curIdx] = i;
                    function(curIdx + 1);
                    operatorCnt[i]++;
                }
            }
        }
    }

    public static int result(){
        int result = num[0];
        for (int i = 0; i < selectedOperator.length; i++) {
            result = calculate(result, num[i + 1], selectedOperator[i]);
        }
        return result;
    }
    public static int calculate(int numA, int numB, int express){
        if(express == 0){
            return numA + numB;
        }else if(express == 1){
            return numA - numB;
        }else if(express == 2){
            return numA * numB;
        }else if(express == 3){
            return numA / numB;
        }else{
            throw new IllegalArgumentException("오류");
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] numStr = br.readLine().split(" ");
        num = new int[N];
        selectedOperator = new int[N - 1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        String[] exCntStr = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operatorCnt[i] = Integer.parseInt(exCntStr[i]);
        }

    }
}
