package pratice.graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 이진검색트리5639 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> numbers =new ArrayList<>();
    public static StringBuffer sb =new StringBuffer();

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    private static void pro() {
        traverse(0, numbers.size() - 1);
        System.out.println(sb);
    }

    private static void traverse(int l, int r) {
        if(l > r) return;
        int mid = r;
        for (int i = l + 1; i <= r; i++) {
            if(numbers.get(i) > numbers.get(l)){
                mid = i - 1;
                break;
            }
        }
        traverse(l + 1, mid);
        traverse(mid + 1, r);
        sb.append(numbers.get(l)).append("\n");
    }

    private static void input() throws IOException {
        String str = "";
        while ((str = br.readLine()) != null) {
            if(str.equals(""))break;
            numbers.add(Integer.parseInt(str));
        }
    }
}
