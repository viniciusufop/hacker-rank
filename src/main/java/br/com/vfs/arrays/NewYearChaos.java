package br.com.vfs.arrays;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        boolean tooChaotic = false;
        int bribes = 0;
        for (int pos = 0; pos < q.length; pos++) {
            int value = q[pos];
            int distance = (value - 1) - pos;
            if (distance > 2) {
                tooChaotic = true;
                break;
            } else if (distance > 0) {
                bribes += distance;
            } else {
                for (int bribedControl = value - 1; bribedControl < pos; bribedControl++) {
                    int bribedValue = q[bribedControl];
                    if (bribedValue > value && (bribedValue - 1) - bribedControl <= 0) bribes++;
                }
            }
        }
        if (tooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }

    public static void main(String... args) {
        int[] values3 = {1, 2, 5, 3, 7, 8, 6, 4};
        System.out.println("Expect is 7");
        minimumBribes(values3);
    }
}
