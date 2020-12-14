package br.com.vfs.arrays;

public class MinimumSwaps2 {
    //TODO não passa em performace
    static int minimumSwaps(int[] arr) {
        /*
        i   arr                         swap (indices)
        0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
        1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
        2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
        3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
        4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
        5   [1, 2, 3, 4, 5, 6, 7]

         */

        int swaps = 0;
        int position = 0;
        do {

            int correctValueByPosition = position + 1;
            if (arr[position] == correctValueByPosition) {
                position++;
            } else {
                for (int pos2 = position + 1; pos2 < arr.length; pos2++) {
                    if (arr[pos2] == correctValueByPosition) {
                        arr[pos2] = arr[position];
                        arr[position] = correctValueByPosition;
                        swaps++;
                        continue;
                    }
                }
            }
        } while (position < arr.length);
        return swaps;
    }

    static int minSwaps(int[] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            //[4, 3, 1, 2]
            if (arr[i] == i + 1)
                continue;

            counter++; //1

            int swap = arr[i];
            arr[i] = arr[swap - 1];
            arr[swap - 1] = swap;
            i--;
        }
        return counter;
    }

    public static void main(String... args) {
        int[] values = {4, 3, 1, 2};//99984
        System.out.println("Expect is 3, result is " + minSwaps(values));
    }
}
