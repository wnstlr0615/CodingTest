package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 정수의 점들인 놓여 있다
// 주어진 점들간 중복은 없다
// 두점 사이의 거리는 두점의 차이
// N = 색깔 수 (1~N 으로 표현)
// 모든 점에 대해서 같은 색깔을 가진 다른 점이 항 사 ㅇ  존재한다.
// 같은 색을 가진 점들 사이 거리의 합
public class 화살표그리기15970 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static Point[] points;
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(points);
        System.out.println(
                sum()
        );
    }

    private static int sum() {
        // 자기 위치에서 왼쪽과 오른쪽에 가까운 곳까지에 거리를 구하기
        // 모든 점에 대하여 가까운 거리 합 구하기
        int minDis;
        int sum = 0;
        for (int i = 0; i < N ; i++) {
            int leftDis = Integer.MAX_VALUE;
            int rightDis = Integer.MAX_VALUE;;
           if(i > 0 && points[i].color == points[i-1].color){
               leftDis = Math.abs(points[i].x - points[i-1].x);
           }
            if(i < N - 1 && points[i].color == points[i + 1].color){
                rightDis = Math.abs(points[i + 1].x - points[i].x);
            }
            minDis = Math.min(leftDis, rightDis);
            sum += minDis;
        }
        return sum;
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] str;
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            points[i] =new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
    }
}

class Point implements Comparable<Point>{
    public int x;
    public int color;

    public Point(int x, int color) {
        this.x = x;
        this.color = color;
    }
    @Override
    public int compareTo(Point p){
        if(color != p.color) return color - p.color;
        return x - p.x;
    }
}
