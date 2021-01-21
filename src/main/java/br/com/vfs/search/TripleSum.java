package br.com.vfs.search;

import java.util.Arrays;
import java.util.TreeSet;

public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        final TreeSet<Integer> setA = new TreeSet<>();
        Arrays.stream(a).forEach(setA::add);
        final TreeSet<Integer> setB = new TreeSet<>();
        Arrays.stream(b).forEach(setB::add);
        final TreeSet<Integer> setC = new TreeSet<>();
        Arrays.stream(c).forEach(setC::add);
        long triples = 0;
        long elementsP = 0;
        long elementsR = 0;
        Integer elementA = setA.first();
        Integer elementC = setC.first();

        for (int elementB: setB) {
            if(elementA != null){
                while(elementA.compareTo(elementB) < 1) {
                    elementsP++;
                    elementA = setA.higher(elementA);
                    if(elementA == null) break;
                }
            }
            if(elementC != null){
                while(elementC.compareTo(elementB) < 1) {
                    elementsR++;
                    elementC = setC.higher(elementC);
                    if(elementC == null) break;
                }
            }
            triples += elementsP*elementsR;
        }
        return triples;
    }

    public static void main(String... args){
        System.out.println("Expect is 5, result is " +
                triplets(new int[]{1,3,5},
                        new int[]{2,3},
                        new int[]{1,2,3}));
        System.out.println("Expect is 12, result is " +
                triplets(new int[]{1, 3, 5, 7},
                        new int[]{5, 7, 9},
                        new int[]{7, 9, 11, 13}));
    }
}
