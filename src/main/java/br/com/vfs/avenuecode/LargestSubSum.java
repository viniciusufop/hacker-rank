package br.com.vfs.avenuecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestSubSum {


    public static List<Long> maxSubsetSum(List<Integer> k) {
        Map<Integer, Long> sumFactors = new HashMap<>();

        return k.stream().map(number -> {
            if (number == 1) return 1L;
            long sumFactor = sumFactors.getOrDefault(number, 0L);
            if(sumFactor != 0) return sumFactor;

            int min = 1;
            int max = number;

            /*
            * 1 - 100
            * 2 - 50
            * 3 -
            * 4 - 25
            * 5 - 20
            * 6 -
            * 7 -
            * 8 -
            * 9 -
            * 10 - 10
            * */

            while (min < max) {
                if (number % min == 0) {
                    max = number / min;
                    if (min != max) {
                        sumFactor += min + max;
                    } else {
                        sumFactor += min;
                    }

                }
                min++;
            }
            sumFactors.put(number, sumFactor);
            return sumFactor;
        }).collect(Collectors.toList());
    }

    public static void main(String... args) {
        System.out.println(maxSubsetSum(List.of(12, 2, 4)));
    }
}
