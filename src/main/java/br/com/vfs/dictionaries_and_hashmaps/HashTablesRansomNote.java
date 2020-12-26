package br.com.vfs.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.Map;

public class HashTablesRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordsNote = new HashMap<>();
        for (String wordNote: note) {
            wordsNote.compute(wordNote, (key, value) -> value == null ? 1 : value+1);
        }
        for (String wordMagazine: magazine) {
           wordsNote.computeIfPresent(wordMagazine,(key, value) -> value-1);
        }
        if(wordsNote.values().stream()
                .map(value -> value <= 0)
                .reduce((a, b) -> a && b).orElse(false)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void main(String... args) {
        System.out.println("Expect is No, result is ");
        checkMagazine("two times three is not four".split(" "),
                "two times two is four".split(" "));
    }




}
