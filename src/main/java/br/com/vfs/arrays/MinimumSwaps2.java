package br.com.vfs.arrays;

public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        int swapCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i+1) continue;
            swapCount++;
            int temp = arr[i];
            arr[i] = arr[temp-1];
            arr[temp-1] = temp;
            i--;
        }
        return swapCount;
    }

    public static void main(String... args) {
        int[] values = {7, 1, 3, 2, 4, 5, 6};
        System.out.println("Expect is 9, result is " + minimumSwaps(values));
    }
}
