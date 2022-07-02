package pratice.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액2470 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    // 키워드
    //산성 용액, 알칼리성 용액
    //산성 용액 1 ~ 10억
    //알 칼리성 용액 용액 -1 ~ -10억
    // 두 용액 합이 0에 가까운 용액 만들기(핵심)
    // N = 용액 수  (2 ~ 10만)
    // 산성 용액 + 음성 용액은 21억 이하 int 범위
    // N 또한 int 범위
    // 두 용액을 오름차 순으로 출력
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] split = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);

        pro(arr);

    }

    private static void pro(int[] arr) {
        int minSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > 0 ){
                break;
            }
            int res = function(arr, i + 1, arr.length - 1, -arr[i]);
            if(i < res && Math.abs(arr[res - 1] + arr[i]) < minSum){
                minSum = Math.abs(arr[res - 1] + arr[i]);
                v1 = arr[i];
                v2 = arr[res - 1];
            }

            if(res < arr.length && Math.abs(arr[res] + arr[i]) < minSum){
                minSum = Math.abs(arr[res] + arr[i]);
                v1 = arr[i];
                v2 = arr[res];
            }
        }
        System.out.println(v1 + " " + v2);
    }
    // result가 X 이상인 배열에 오른쪽 값
    // -2
    //-10 -8 -3  -1  1 3 5 7 9
    private static int function(int[] arr, int L, int R, int num) {
        int res = R;
        while(L <= R){
            int mid = (L + R) / 2;
            if(num <= arr[mid]){
                res = mid;
                R = mid -1;
            }else{
                L = mid + 1;
            }
        }
        return res;
    }
}
