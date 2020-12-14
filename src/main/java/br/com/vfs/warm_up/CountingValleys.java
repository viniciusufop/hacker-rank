package br.com.vfs.warm_up;


public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int countingValleys = 0;
        boolean startValleys = false;
        int height = 0;

        for (int count = 0; count < steps; count++) {
            if(path.charAt(count) == 'D') height--;
            else height++;

            if(height == 0){
                if(startValleys) countingValleys++;
                startValleys = false;
            }
            else if(height == -1) startValleys = true;
        }
        return countingValleys;
    }

    public static void main(String... args) {
        System.out.println("Expect is 1, result is " + countingValleys(8, "UDDDUDUU"));
    }
}

