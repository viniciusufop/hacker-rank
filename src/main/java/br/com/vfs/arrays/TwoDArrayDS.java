package br.com.vfs.arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayDS {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        List<Integer> sums = new ArrayList<Integer>();
        for (int row = 0; row < arr.length-2; row++) {
            for (int column = 0; column < arr[row].length-2; column++) {
                sums.add((new HourGlasses(row, column, arr)).calculate());
            }
        }
        return sums.stream().max(Integer::compareTo).orElse(0);
    }

    static class HourGlasses {

        private final int initialRow;
        private final int initialColumn;
        private final int[][] arr;

        public HourGlasses(int initialRow, int initialColumn, int[][] arr) {
            this.initialRow = initialRow;
            this.initialColumn = initialColumn;
            this.arr = arr;
        }
        public int calculate(){
            return arr[initialRow][initialColumn] + arr[initialRow][initialColumn+1]
                    + arr[initialRow][initialColumn+2] + arr[initialRow+1][initialColumn+1]
                    + arr[initialRow+2][initialColumn] + arr[initialRow+2][initialColumn+1]
                    + arr[initialRow+2][initialColumn+2];
        }
    }

    public static void main(String... args) {
        int[][] values =
                {
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}
                };
        System.out.println("Expect is 19, result is " + hourglassSum(values));
    }
}
