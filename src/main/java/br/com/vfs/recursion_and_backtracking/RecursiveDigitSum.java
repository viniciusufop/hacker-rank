package br.com.vfs.recursion_and_backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecursiveDigitSum {

    static int superDigit(String n, int k) {
        final Map<Integer, Long> map = new HashMap<>();
        Arrays.stream(n.split(""))
                .map(Integer::parseInt)
                .forEach(value -> map.compute(value, (key, v) -> v == null ? 1 : ++v));
        Long count = map.entrySet()
                .stream()
                .map(entry -> k * entry.getKey() * entry.getValue())
                .reduce(0L, Long::sum);
        if(count < 10) return count.intValue();
        return superDigit(String.valueOf(count), 1);
    }

    public static void main(String... args) {
        System.out.println("Expect is 9, result is "+ superDigit("123", 3));
        System.out.println("Expect is 8, result is "+ superDigit("9875", 4));
        System.out.println("Expect is 3, result is "+ superDigit("148", 3));
    }

}
