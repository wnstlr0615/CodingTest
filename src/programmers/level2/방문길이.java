package programmers.level2;

import java.util.ArrayList;

public class 방문길이 {

    public static void main(String[] args) {
        solution("ULURRDLLU");
    }
    public static int solution(String dirs) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        String str = "UDRL";
        int x = 0;
        int y = 0;
        ArrayList<String> dis = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dirs.length(); i++) {
            int idx = str.indexOf(dirs.charAt(i) + "");
            int newX = x + dx[idx];
            int newY = y + dy[idx];
            if(newX >= -5 && newY >= -5 && newX <= 5 && newY <= 5){
                sb.append(x).append(y).append(newX).append(newY);
                if(!dis.contains(sb.toString())){
                    dis.add(sb.toString());
                    sb.setLength(0);
                    dis.add(sb.append(newX).append(newY).append(x).append(y).toString());
                }
                x = newX;
                y = newY;
            }
            sb.setLength(0);
        }
        System.out.println(dis);
        System.out.println(dis.size()/2);
        return dis.size()/2;
    }
}
