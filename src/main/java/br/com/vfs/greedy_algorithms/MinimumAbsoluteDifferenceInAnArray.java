package br.com.vfs.greedy_algorithms;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MinimumAbsoluteDifferenceInAnArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        final Set<Integer> elements = new TreeSet<>();
        for (int value: arr) {
            if(elements.contains(value)) return 0;
            elements.add(value);
        }
        Iterator<Integer> iterator = elements.iterator();
        int valueOne = iterator.next();
        int valueTwo = iterator.next();
        int minimumAbsolute = calcBaseTwoPositions(valueOne, valueTwo);
        while (iterator.hasNext()) {
            valueOne = valueTwo;
            valueTwo = iterator.next();
            int cal = calcBaseTwoPositions(valueOne, valueTwo);
            if (minimumAbsolute > cal) minimumAbsolute = cal;
        }
        return minimumAbsolute;
    }

    static int calcBaseTwoPositions(int valueOne, int valueTwo){
        int cal = valueOne - valueTwo;
        return (cal < 0) ? cal * -1 : cal;
    }

    public static void main(String... args) {
        int[] x = {3, -7, 0};
        System.out.println("Expect is 3, result is " + minimumAbsoluteDifference(x));
    }
}
