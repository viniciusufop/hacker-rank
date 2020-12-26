package br.com.vfs.string_manipulation;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        /*
        Solução baseada nas tratativas do problema da maior subsequencia comum
        https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
         */
        int[][] matrix = new int[s1.length()+1][s2.length()+1];
        for (int posStringOne = 1; posStringOne <= s1.length(); posStringOne++){
            for (int posStringTwo = 1; posStringTwo <= s2.length(); posStringTwo++)
            {
                if (s1.charAt(posStringOne - 1) == s2.charAt(posStringTwo - 1))
                    matrix[posStringOne][posStringTwo] = matrix[posStringOne - 1][posStringTwo - 1] + 1;
                else
                    matrix[posStringOne][posStringTwo] = Math.max(matrix[posStringOne][posStringTwo - 1], matrix[posStringOne - 1][posStringTwo]);
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    public static void main(String... args) {
        System.out.println("Expect is 15, result is " +
                commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
                        "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
    }
}
