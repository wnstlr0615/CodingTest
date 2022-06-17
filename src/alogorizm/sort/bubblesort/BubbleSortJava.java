package alogorizm.sort.bubblesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSortJava {
    public void sort(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            boolean swap = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if(arrayList.get(j) > arrayList.get(j+1)){
                    Collections.swap(arrayList, j, j+1);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortJava bubbleSortJava = new BubbleSortJava();
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(5, 6, 9, 1, 3, 1, 5, 7, 10));
        bubbleSortJava.sort(integers);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
