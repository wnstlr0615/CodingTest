package alogorizm.sort.quicksort;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> arrayList){
        if(arrayList.size()  <= 1){
            return arrayList;
        }
        int pivot = 0;
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(pivot) >= arrayList.get(i)){
                leftArr.add(arrayList.get(i));
            }else{
                rightArr.add(arrayList.get(i));
            }
        }
        System.out.println("leftArr : " + leftArr);
        System.out.println("rightArr : " + rightArr);

        ArrayList<Integer> mergeSortList = new ArrayList<>();
        mergeSortList.addAll(sort(leftArr));
        mergeSortList.add(arrayList.get(pivot));
        mergeSortList.addAll(sort(rightArr));
        System.out.println("mergeSort : " + mergeSortList);
        return mergeSortList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        IntStream.rangeClosed(0, 10)
                .forEach(i -> arrayList.add(random.nextInt(100)));

        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> sortList = quickSort.sort(arrayList);

    }
}
