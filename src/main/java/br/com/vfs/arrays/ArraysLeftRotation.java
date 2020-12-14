package br.com.vfs.arrays;

import java.util.Arrays;

public class ArraysLeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        for (int pos = 0; pos < a.length; pos++){
            int positionArr = pos+d;
            if(positionArr >= a.length) result[pos] = a[positionArr - a.length];
            else result[pos] = a[pos+d];
        }
        return result;
    }

    public static void main(String... args) {
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("Expect is [5, 1, 2, 3, 4], result is " + Arrays.toString(rotLeft(values, 4)));
    }
}
