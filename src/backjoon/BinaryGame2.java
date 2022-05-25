package backjoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BinaryGame2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.print(0);
        IntStream.rangeClosed(0,n)
                .forEach(num -> {
                    while(num>0){
                        sb.append(num%2);
                        num/=2;
                    }
                    sb.reverse();
                    System.out.print(sb);
                    sb = new StringBuffer();
                });
    }
}
