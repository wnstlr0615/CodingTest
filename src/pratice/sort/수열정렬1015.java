package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// P[0]~ P[N-1] =  0 ~ N-1을 한번 씩 포함 하는 수
//길이 N인 A 에 P를 적용 시 길이 N인 배열 B
//B[P[i]] = A[i]
// 배열 A를  비 내림차 순으로 만드는 만드는 배열 P를 구하라
// 비 내림차 순이란 뒤에 원소가 앞보다 같거나 큰 경우

public class 수열정렬1015 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] P;
    public static Elem[] elems;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(elems);
        for (int i = 0; i < elems.length; i++) {
            P[elems[i].idx] = i;
        }
        Arrays.stream(P).forEach(e -> System.out.print(e + " "));
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        elems = new Elem[N];
        P = new int[N];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < str.length; i++) {
            elems[i] = new Elem(i, Integer.parseInt(str[i]));
        }
    }
// 0 1 2
// 2 3 1
// 1 2 3
}

class Elem implements Comparable<Elem> {
    int idx;
    int num;

    public Elem(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
    @Override
    public int compareTo(Elem elem) {
        return num - elem.num;
    }
}
