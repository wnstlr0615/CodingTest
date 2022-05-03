package alogorizm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(ArrayList<Integer> arrayList, int data){
        if(arrayList.size() <= 0){
            return -1;
        }
        int mid;
        int p = 0;
        int q = arrayList.size()-1;
        while(p <= q){
            mid = (p + q) / 2;
            if(arrayList.get(mid) == data){
                return mid;
            }else if(data < arrayList.get(mid)){
                q = mid - 1;
            }else{
                p = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9, 10, 12, 15));
        System.out.println(
                binarySearch.binarySearch(arrayList, 12)
        );
    }
}
