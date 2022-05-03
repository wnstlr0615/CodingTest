package alogorizm.dynamic;

public class Fibonacci {
    public int fibonacci(int n){
        if(n == 0){
            return  0;
        }else if(n == 1){
            return 1;
        }else{
            return  fibonacci(n-1) +fibonacci(n-2);
        }
    }
    public int dynamicFibonacci(int n){
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <=n ; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long start  = System.currentTimeMillis();
        System.out.println(fibonacci.fibonacci(30));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fibonacci.dynamicFibonacci(30));
        System.out.println(System.currentTimeMillis() - start);

    }
}
