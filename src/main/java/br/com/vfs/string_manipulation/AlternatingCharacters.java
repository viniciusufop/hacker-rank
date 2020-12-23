package br.com.vfs.string_manipulation;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int removeChars = 0;
        for(int pos = 0; pos < s.length()-1; pos++){
            if(s.charAt(pos) == s.charAt(pos+1))removeChars++;
        }
        return removeChars;
    }

    public static void main(String... args) {
        final String string = "AAABBBAABB";
        System.out.println("Expect is 6, result is " + alternatingCharacters(string));
    }
}
