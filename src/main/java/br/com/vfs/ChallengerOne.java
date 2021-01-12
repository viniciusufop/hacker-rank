package br.com.vfs;

public class ChallengerOne {

    static int test(final String phrase){
        int max = 0;
        for (int pos = 0; pos < phrase.length()-1; pos++){
            int value = Integer.parseInt(phrase.substring(pos, pos+2));
            if(max < value) max = value;
        }
        return max;
    }

    public static void main(String... args){
        System.out.println(test("50552"));
    }
}
