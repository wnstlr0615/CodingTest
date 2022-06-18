package alogorizm.sort.mergesort;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSortJava {
    public ArrayList<Integer> split(ArrayList<Integer> arrayList){
        if(arrayList.size() <= 1){
            return arrayList;
        }
        int mid = arrayList.size() / 2;

        ArrayList<Integer> leftArr = split( new ArrayList<>(arrayList.subList(0, mid)));
        ArrayList<Integer> rightArr = split(new ArrayList<>(arrayList.subList(mid, arrayList.size())));
        return merge(leftArr, rightArr);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> sortList = new ArrayList<>();
        int lp = 0 , rp = 0;

        while(lp < leftArr.size() && rp < rightArr.size()){
            if(leftArr.get(lp) <= rightArr.get(rp)){
                sortList.add(leftArr.get(lp));
                lp++;
            }else{
                sortList.add(rightArr.get(rp));
                rp++;
            }
        }
        while(lp < leftArr.size()){
            sortList.add(leftArr.get(lp));
            lp++;
        }
        while(rp < rightArr.size()){
            sortList.add(rightArr.get(rp));
            rp++;
        }
        return sortList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        IntStream.rangeClosed(0, 100)
                .forEach(i -> arrayList.add(random.nextInt(100)));
        MergeSortJava mergeSortJava = new MergeSortJava();
        ArrayList<Integer> sortList = mergeSortJava.split(arrayList);
        sortList.forEach(System.out::println);
    }
}
