package br.com.vfs.greedy_algorithms;

import java.util.Map;
import java.util.TreeMap;

public class ReverseShuffleMerge {
    /*
    reverse(egg)-gge
    shuffle(egg)-egg
    merge(gge, egg)
    gge
    egg

    eggegg => egg


    reverse(abcdefg) gfedcba
    shuffle(abcdefg) abcdefg
    merge(gfedcba, abcdefg) => abcdefggfedcba

    aeiou uoiea
    reverse(aeiou) uoiea

     */

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        System.out.println(reverse(s.substring(0,s.length()/2)));
        System.out.println(shuffle(s.substring(s.length()/2)));

        return s;
    }

    static String reverse(String value){
        char[] chars = value.toCharArray();
        int initialPos = 0;
        int finalPos = value.length()-1;
        while (initialPos < finalPos){
            char aux = value.charAt(initialPos);
            chars[initialPos] = chars[finalPos];
            chars[finalPos] = aux;
            initialPos++;
            finalPos--;
        }
        return String.valueOf(chars);
    }

    static String shuffle(String value){
        Map<Character, Integer> mapChars = new TreeMap<>();
        for (char c: value.toCharArray()) {
            mapChars.compute(c, (k,v) -> v == null ? 1 : ++v);
        }
        StringBuilder builder = new StringBuilder();
        mapChars.forEach((k,v) -> {
            int aux = 0;
            while(aux < v){
                builder.append(k);
                aux++;
            }
        });
        return builder.toString();
    }
    public static void main(String... args) {
        System.out.println("Expect is egg, result is " + reverseShuffleMerge("eggegg"));
        System.out.println("Expect is agfedcb, result is " + reverseShuffleMerge("abcdefgabcdefg"));
        System.out.println("Expect is aeiou, result is " + reverseShuffleMerge("aeiouuoiea"));
    }
    /*
        s= abab
        ab ab


        reverse(ab)= ba
        s=a ba b <= ab

        gfedcba
        abcdefg abcdefg

        abcdefg
        gfedcba gfedcba

        abcdefg =>bcdefga

        aeiouuoiea



     */

}
