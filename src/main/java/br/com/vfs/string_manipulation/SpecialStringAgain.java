package br.com.vfs.string_manipulation;

import java.util.ArrayList;

public class SpecialStringAgain {
    static class Pair {
        char value;
        int countSeqPos;

        public Pair(char value, int countSeqPos) {
            this.value = value;
            this.countSeqPos = countSeqPos;
        }
    }
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        final ArrayList<Pair> pairs = new ArrayList<>();
        //percorrer toda a lista
        for (int initialPos = 0; initialPos < n; initialPos++){
            int pos = initialPos+1;
            while (pos < s.length() && s.charAt(pos) == s.charAt(initialPos)) pos++;
            pairs.add(new Pair(s.charAt(initialPos), pos - initialPos));
            initialPos = pos - 1;
        }

        long countSpecialSubStrings = 0;
        for (int pos = 0; pos < pairs.size(); pos++) {
            Pair pair = pairs.get(pos);
            countSpecialSubStrings += (1 + pair.countSeqPos) * pair.countSeqPos / 2;
            if (pair.countSeqPos == 1 && pos > 0 && pos < pairs.size() - 1) {
                Pair pre = pairs.get(pos - 1);
                Pair next = pairs.get(pos + 1);
                if (pre.value == next.value) {
                    countSpecialSubStrings += Math.min(pre.countSeqPos, next.countSeqPos);
                }
            }
        }
        return countSpecialSubStrings;
    }

    public static void main(String... args) {
        System.out.println("Expect is 10, result is " +substrCount(7, "abcbaba"));
    }
}
