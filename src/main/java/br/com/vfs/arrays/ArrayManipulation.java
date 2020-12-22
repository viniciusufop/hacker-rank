package br.com.vfs.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        /*
            I incremented two index because:
                - I ignored zero index
                - Is necessary add final index for calculate values
         */
        long[] result = new long[n+2];
        for (int[] query : queries) {
            int initialPos = query[0];
            int finalPos = query[1];
            int value = query[2];
            /*
                Eliminated internal loop (real problem)
                while (initialPos <= finalPos) {
                    result[initialPos] += value;
                    initialPos++;
                }
             */
            result[initialPos] += value;
            result[finalPos+1] -= value;
        }
        /*
            Process and identifier max value
         */
        long max = 0;
        long internalResultValue = 0;
        for (long value: result) {
            internalResultValue += value;
            if(max < internalResultValue) max = internalResultValue;
        }
        return max;
    }

//    // Complete the arrayManipulation function below.
//    static long arrayManipulation(int n, int[][] queries) {
//        long outputArray[] = new long[n + 2];
//        for (int i = 0; i < queries.length; i++) {
//            int a = queries[i][0];
//            int b = queries[i][1];
//            int k = queries[i][2];
//            outputArray[a] += k;
//            outputArray[b+1] -= k;
//        }
//        long max = getMax(outputArray);
//        return max;
//    }
//
//    private static long getMax(long[] inputArray) {
//        long max = Long.MIN_VALUE;
//        long sum = 0;
//        for (int i = 0; i < inputArray.length; i++) {
//            sum += inputArray[i];
//            max = Math.max(max, sum);
//        }
//        return max;
//    }


    public static void main(String... args) {
        int[][] values =
                {
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                };
        System.out.println("Expect is 200, result is " + arrayManipulation(5,values));
    }
}
