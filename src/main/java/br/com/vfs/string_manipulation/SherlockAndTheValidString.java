package br.com.vfs.string_manipulation;


import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(chars -> map.compute(chars, (key, value) -> value == null ? 1 : value+1));
        boolean removeJustOne = false;
        int countOneElement = map.values().stream().findFirst().orElse(0);
        for (int count: map.values()) {
            if(count == countOneElement) continue;
            if(countOneElement == 1 && !removeJustOne) {
                countOneElement = count;
                removeJustOne = true;
                continue;
            }
            if((count == 1
                    || count - countOneElement == 1
                    || countOneElement - count == 1) && !removeJustOne) {
                removeJustOne = true;
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    public static void main(String... args) {
        final String first = "aabbcd";
        System.out.println("Expect is NO, result is " +isValid(first));
    }
}
