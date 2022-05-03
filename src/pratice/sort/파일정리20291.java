package pratice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파일정리20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, ArrayList<String>> files = new TreeMap();
        String filename;
        String ext;
        for (int i = 0; i < n; i++) {
            filename = br.readLine();
            ext = filename.substring(filename.lastIndexOf(".") + 1);
            if(files.containsKey(ext)){
                    files.get(ext).add(filename);
            }else{
               files.put(ext, new ArrayList<>(List.of(filename)));
            }
        }

        files.forEach(
                (key, list) -> System.out.println(key + " "+ list.size())
        );
    }
}
