package br.com.vfs.sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        final Map<Integer, Integer> toysByPrice = new TreeMap<>();
        Arrays.stream(prices)
                .filter(price -> price <= k)
                .forEach(price -> toysByPrice.compute(price, (key, v) -> v == null ? 1 : ++v));
        int budget = k;
        int maxToys = 0;
        for (int price: toysByPrice.keySet()) {
            if(price > budget) break;
            int qtdSell = budget/price;
            int qtd = toysByPrice.get(price);
            if(qtd > qtdSell) {
                maxToys+= qtdSell;
                budget -= qtdSell*price;
            } else {
                maxToys+= qtd;
                budget -= qtd*price;
            }
        }
        return maxToys;
    }

    public static void main(String... args) {
        int[] i = {1, 12, 5, 111, 200, 1000, 10};
        System.out.println("Expect is 4, result is "+maximumToys(i, 50));
    }
}
