package br.com.vfs.arrays;


public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        /*
            I incremented two index because:
                - I ignored zero index
                - Is necessary add final index for calculate values
         */
        long[] result = new long[n+2];
        for (int[] query : queries) {
            int initialPos = query[0];
            int finalPos = query[1];
            int value = query[2];
            /*
                Eliminated internal loop (real problem)
                while (initialPos <= finalPos) {
                    result[initialPos] += value;
                    initialPos++;
                }
             */
            result[initialPos] += value;
            result[finalPos+1] -= value;
        }
        /*
            Process and identifier max value
         */
        long max = 0;
        long internalResultValue = 0;
        for (long value: result) {
            internalResultValue += value;
            if(max < internalResultValue) max = internalResultValue;
        }
        return max;
    }

    public static void main(String... args) {
        int[][] values =
                {
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                };
        System.out.println("Expect is 200, result is " + arrayManipulation(5,values));
    }
}
