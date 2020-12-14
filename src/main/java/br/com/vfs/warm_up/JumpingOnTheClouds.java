package br.com.vfs.warm_up;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int jump = 0;
        for(int count = 0; count < c.length-1; count++){
            if(count+2 < c.length && c[count+2] == 0) count++;
            jump++;
        }
        return jump;
    }

    public static void main(String... args) {
        int[] test = {0,0,1,0,0,1,0};
        System.out.println("Expect is 4, result is " + jumpingOnClouds(test));
    }
}
