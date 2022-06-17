package alogorizm.sort.selectsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SelectSortJava {
    public void sort(ArrayList<Integer> arrayList){
        int select;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            select = i;
            for (int j = i + 1; j < size ; j++) {
                if(arrayList.get(select) > arrayList.get(j)){
                    select = j;
                }
            }
            Collections.swap(arrayList, i, select);
        }
    }

    public static void main(String[] args) {
        SelectSortJava selectSortJava = new SelectSortJava();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(100));
        }
        selectSortJava.sort(arrayList);

        arrayList.forEach(System.out::println);

    }
}
