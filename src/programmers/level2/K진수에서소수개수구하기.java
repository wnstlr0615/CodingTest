package programmers.level2;

import java.util.StringTokenizer;

public class K진수에서소수개수구하기 {
    public static void main(String[] args) {
        solution(1000000, 2);
    }

    public static int solution(int n, int k) {
        String number = fun(n, k);
        StringTokenizer st = new StringTokenizer(number, "0");
        int answer = 0;
        while(st.hasMoreTokens()){
            if(isPrime(Long.parseLong(st.nextToken())))answer++;
        }

        return answer;
    }

    private static boolean isPrime(long number) {
        long sqrt = (long) Math.sqrt(number);
        if( number == 1)return false;
        for (int i = 2; i <= sqrt; i++) {
            if(number%i == 0)return false;
        }
        return true;
    }

    private static String fun(int n, int k) {
        StringBuffer sb = new StringBuffer();
        int temp = n;
        while(temp > 0){
            sb.append(temp%k);
            temp/=k;
        }
        return sb.reverse().toString();
    }
}
