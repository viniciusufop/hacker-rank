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

            int correctValueByPosition = position+1;
            if(arr[position] == correctValueByPosition) {
                position++;
            } else {
                for (int pos2 = position+1; pos2 < arr.length; pos2++){
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

    public static void main(String... args) {
        int[] values = {4, 3, 1, 2};//99984
        System.out.println("Expect is 3, result is " + minimumSwaps(values));
    }
}
