package br.com.vfs.dictionaries_and_hashmaps;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SherlockAndAnagrams {

    static class SubString {
        Map<Character, Integer> countByChar;

        public SubString(String substring) {
            this.countByChar = new HashMap<>();
            for (char letter : substring.toCharArray())
                countByChar.compute(letter, (k, v) -> v == null ? 1 : ++v);
        }

        @Override
        public boolean equals(Object obj) {
            SubString o = (SubString) obj;
            if (countByChar.size() != o.countByChar.size()) return false;
            for (char letter : countByChar.keySet()) {
                if(!countByChar.get(letter).equals(o.countByChar.get(letter))) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(countByChar);
        }
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int subStringSize = 1;
        int countSpecialSubStrings = 0;
        while (subStringSize < s.length()){
            Map<SubString, Integer> substrings = new HashMap<>();
            for (int pos = 0; pos + subStringSize <= s.length(); pos++){
                SubString word = new SubString(s.substring(pos, pos + subStringSize));
                substrings.compute(word, (k, v) -> v == null ? 1 : ++v);
            }

            countSpecialSubStrings += substrings.values()
                    .stream()
                    .filter(v -> v > 1)
                    .map(v -> v*(v-1)/2)
                    .reduce(Integer::sum)
                    .orElse(0);
            subStringSize++;
        }
        return countSpecialSubStrings;
    }
    public static void main(String... args) {
        System.out.println("Expect is 10, result is "+ sherlockAndAnagrams("kkkk"));
        System.out.println("Expect is 3, result is "+ sherlockAndAnagrams("ifailuhkqq"));
    }
}
