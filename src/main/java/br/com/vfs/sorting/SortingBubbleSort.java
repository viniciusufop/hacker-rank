package br.com.vfs.sorting;

public class SortingBubbleSort {
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int numSwaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    numSwaps++;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", numSwaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[a.length-1]);
    }
    public static void main(String... args) {
        System.out.println("Expect is \n" +
                "Array is sorted in 3 swaps.  \n" +
                "First Element: 1  \n" +
                "Last Element: 6 \n" +
                ", result is ");
        int[] i = {6, 4, 1};
        countSwaps(i);
    }

}
