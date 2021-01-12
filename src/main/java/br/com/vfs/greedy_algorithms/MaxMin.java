package br.com.vfs.greedy_algorithms;

import java.util.Arrays;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minUnfairness = arr[k-1] - arr[0];
        for (int pos = 1; pos <= arr.length - k; pos++){
            int unfairness = arr[pos+k-1] - arr[pos];
            if(minUnfairness > unfairness) minUnfairness = unfairness;
        }
        return minUnfairness;
    }

    public static void main(String... args) {
        int[] x = {10, 100, 300, 200, 1000, 20, 30};
        System.out.println("Expect is 20, result is " + maxMin(3, x));
    }
}
