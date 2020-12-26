package br.com.vfs.dictionaries_and_hashmaps;

import java.util.Set;
import java.util.TreeSet;

public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean  commonLetter = false;
        Set<Character> characterSet = new TreeSet<>();
        for (char chars : s1.toCharArray()){
            characterSet.add(chars);
        }
        for (char chars2 : s2.toCharArray()) {
            if(characterSet.contains(chars2)){
                commonLetter = true;
                break;
            }
        }
        return commonLetter ? "YES" : "NO";
    }

    public static void main(String... args) {
        System.out.println("Expect is YES, result is "+
                twoStrings("aardvark", "apple"));
    }
}
