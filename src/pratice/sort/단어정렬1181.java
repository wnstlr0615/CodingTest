package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단어정렬1181 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> wordList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(!wordList.contains(word)) {
                wordList.add(word);
            }
        }

        wordList.sort(
                (a, b) -> {
                    if(a.length()  != b.length()) return a.length() - b.length();
                    return a.compareTo(b);
                }
        );
        wordList.forEach(System.out::println);
    }
}
