package br.com.vfs.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pairs {

    static int pairs(int k, int[] arr) {
        int countOfPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr)
                .forEach(value -> map.compute(value, (key,v) -> v == null ? 1 : ++v));
        for (int value: map.keySet()){
            Integer qtdvaluePlusK = map.get(value + k);
            if (qtdvaluePlusK != null) {
                countOfPairs += map.get(value) * qtdvaluePlusK;
            }

        }
        return countOfPairs;
    }

    public static void main(String... args) {
        int[] values = {1, 5, 3, 4, 2};
        System.out.println("Expect is 3, result is " + pairs(2, values));
    }
}
