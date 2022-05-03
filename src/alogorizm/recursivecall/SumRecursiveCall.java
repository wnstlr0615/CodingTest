package alogorizm.recursivecall;

import java.util.ArrayList;
import java.util.Arrays;

public class SumRecursiveCall {
    public int sum(int num){
        if(num <= 1){
            return 1;
        }else{
            return num + sum(num - 1);
        }
    }
    public int sum(ArrayList<Integer> arrayList){
        if(arrayList.size() > 0){
            return arrayList.remove(arrayList.size() - 1) + sum(arrayList);
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        SumRecursiveCall sumRecursiveCall = new SumRecursiveCall();
        System.out.println(sumRecursiveCall.sum(10));

        ArrayList arrayList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(sumRecursiveCall.sum(arrayList));
    }
}
