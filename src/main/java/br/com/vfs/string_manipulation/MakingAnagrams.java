package br.com.vfs.string_manipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MakingAnagrams {

    private static final Map<Character, Integer> DEFAULT_MAP = new HashMap<>();

    static {
        DEFAULT_MAP.put('a', 0);
        DEFAULT_MAP.put('b', 0);
        DEFAULT_MAP.put('c', 0);
        DEFAULT_MAP.put('d', 0);
        DEFAULT_MAP.put('e', 0);
        DEFAULT_MAP.put('f', 0);
        DEFAULT_MAP.put('g', 0);
        DEFAULT_MAP.put('h', 0);
        DEFAULT_MAP.put('i', 0);
        DEFAULT_MAP.put('j', 0);
        DEFAULT_MAP.put('k', 0);
        DEFAULT_MAP.put('l', 0);
        DEFAULT_MAP.put('m', 0);
        DEFAULT_MAP.put('n', 0);
        DEFAULT_MAP.put('o', 0);
        DEFAULT_MAP.put('p', 0);
        DEFAULT_MAP.put('q', 0);
        DEFAULT_MAP.put('r', 0);
        DEFAULT_MAP.put('s', 0);
        DEFAULT_MAP.put('t', 0);
        DEFAULT_MAP.put('u', 0);
        DEFAULT_MAP.put('v', 0);
        DEFAULT_MAP.put('w', 0);
        DEFAULT_MAP.put('x', 0);
        DEFAULT_MAP.put('y', 0);
        DEFAULT_MAP.put('z', 0);
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(final String a, final String b) {
        final Map<Character, Integer> mapperStringA = generateMapChars(a);
        final Map<Character, Integer> mapperStringB = generateMapChars(b);
        int removeChars = 0;
        final Set<Character> characters = mapperStringA.keySet();
        for (char key: characters) {
            int countA = mapperStringA.get(key);
            int countB = mapperStringB.get(key);
            removeChars += countA > countB ? countA - countB : countB - countA;
        }
        return removeChars;
    }

    static Map<Character, Integer> generateMapChars(String string){
        final Map<Character, Integer> map = new HashMap<>(DEFAULT_MAP);
        for (int pos = 0; pos < string.length(); pos++){
            char character = string.charAt(pos);
            map.compute(character, (key, value) -> value == null ? 1 : value + 1);
        }
        return map;
    }
}
