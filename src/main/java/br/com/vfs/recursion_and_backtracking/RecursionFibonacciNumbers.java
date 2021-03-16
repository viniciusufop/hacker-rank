package br.com.vfs.recursion_and_backtracking;

public class RecursionFibonacciNumbers {

    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String... args) {
        System.out.println("Expect is 5, result is "+ fibonacci(5));
        System.out.println("Expect is 144, result is "+ fibonacci(12));
    }

}
