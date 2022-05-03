package alogorizm.sort.insertionsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSort {
    public void sort(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if(arrayList.get(j) < arrayList.get(j-1)){
                    Collections.swap(arrayList, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        IntStream.rangeClosed(0, 100)
                .forEach(i -> arrayList.add(random.nextInt(100)));
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arrayList);
        arrayList.forEach(System.out::println);
    }
}
