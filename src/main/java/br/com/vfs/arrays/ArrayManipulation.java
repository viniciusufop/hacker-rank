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
        Map<Integer, Map<Integer, Long>> results = new HashMap<>();
        HashMap<Integer, Long> firstElement = new HashMap<>();
        firstElement.put(n, 0);
        results.put(1, firstElement);
//        Map<Integer, Long> results = new ConcurrentHashMap<>();
//        Arrays.stream(queries)
//                .parallel()
//                .forEach(query -> {
//                    int indexInitial = query[0];
//                    int indexFinal = query[1];
//                    long value = query[2];
//                    do {
//                        results.compute(indexInitial, (k, v) -> v == null ? value : v+value);
//                        indexInitial++;
//                    } while (indexInitial <= indexFinal);
//                });
//        return results.values()
//                .stream()
//                .reduce(Long::max)
//                .orElse(0L);

        long[] resultant = new long[n];
        for (int[] query: queries) {
            int indexFinal = query[1] - 1;
            for (int indexInitial = query[0] - 1; indexInitial <= indexFinal; indexInitial++){
                resultant[indexInitial] += query[2];
            }
        }
        long maxValue = 0;
        for (long result: resultant) {
            if (result > maxValue)
                maxValue = result;
        }
        return maxValue;
    }


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
