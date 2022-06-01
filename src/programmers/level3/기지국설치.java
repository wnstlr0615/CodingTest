package programmers.level3;

public class 기지국설치 {
    public static void main(String[] args) {
        solution(11, new int[]{4, 11}, 1);
        solution(16, new int[]{9}, 2);
    }
    public static int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int dis = stations[0] - w - 1;
        double range = w * 2 + 1;
        if(dis > 0){
            cnt +=Math.ceil(dis / range) ;
        }

        for (int i = 1; i <stations.length ; i++) {
            dis = (stations[i] - w) - (stations[i - 1] + w) - 1;
            if(dis <= 0)continue;
            cnt +=Math.ceil(dis / range) ;
        }

        dis = n - (stations[stations.length - 1] + w);
        if(dis >0){
            cnt +=Math.ceil(dis / range) ;
        }
        System.out.println(cnt);
        return cnt;
    }
}
