package pratice.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 물통2251보류 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] limit = new int[3];
    public static void main(String[] args) throws IOException {
        input();

    }

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(split[i]);
        }
    }

}
class State {
    public int[] arr;


    public State(int[] arr) {
        this.arr = arr;
    }
}

