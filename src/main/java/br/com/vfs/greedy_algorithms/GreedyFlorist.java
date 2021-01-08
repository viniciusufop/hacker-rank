package br.com.vfs.greedy_algorithms;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class GreedyFlorist {


    static class IntegerComparatorDesc implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return y.compareTo(x);
        }
    }

    static class Person{
        Map<Integer, Integer> mapFlowers = new TreeMap<>(new IntegerComparatorDesc());

        public void addFlower(int flowerValue){
            mapFlowers.compute(flowerValue, (key, v) -> v == null ? 1 : ++v);
        }

        public int purchase() {
            int aux = 0;
            int purchase = 0;
            for (Map.Entry<Integer, Integer> entry : mapFlowers.entrySet()) {
                Integer flowerValue = entry.getKey();
                Integer qtd = entry.getValue();
                int x = 1;
                while (x <= qtd){
                    purchase += flowerValue * (aux+1);
                    aux++;
                    x++;
                }
            }
            return purchase;
        }
    }

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Map<Integer, Person> persons = new TreeMap<>();
        for (int x = 1; x<=k; x++){
            persons.put(x, new Person());
        }

        Map<Integer, Integer> mapFlowers = new TreeMap<>(new IntegerComparatorDesc());
        for (int flowerValue : c){
            mapFlowers.compute(flowerValue, (key, v) -> v == null ? 1 : ++v);
        }

        int person = 1;
        for (Map.Entry<Integer, Integer> entry : mapFlowers.entrySet()) {
            Integer flowerValue = entry.getKey();
            Integer qtd = entry.getValue();
            while (qtd > 0){
                persons.get(person)
                        .addFlower(flowerValue);
                person = (person == k) ? 1 : ++person;
                qtd--;
            }
        }

        return persons.values()
                .stream()
                .map(Person::purchase)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static void main(String... args) {
        int[] x = {1, 3, 5, 7, 9};
        System.out.println("Expect is 29, result is " + getMinimumCost(3, x));
    }
}
