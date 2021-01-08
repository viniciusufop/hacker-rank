package br.com.vfs.greedy_algorithms;

import java.util.Map;
import java.util.TreeMap;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int luckBalance = 0;
        int countImportantContests = 0;
        Map<Integer, Integer> mapContests = new TreeMap<>();
        for (int[] contest: contests) {
            if(contest[1] == 0) luckBalance += contest[0];
            else {
                countImportantContests++;
                mapContests.compute(contest[0], (key, v) -> v == null? 1 : ++v);
            }
        }
        if(countImportantContests <= k) {
            for (int luck: mapContests.keySet()) {
                luckBalance += luck * mapContests.get(luck);
            }
            return luckBalance;
        }
        int winImportantContests = countImportantContests - k;
        for (int luck: mapContests.keySet()) {
            int contestByLuck = mapContests.get(luck);
            if(winImportantContests == 0){
                luckBalance += luck * contestByLuck;
            } else if(contestByLuck <= winImportantContests) {
                luckBalance -= luck * contestByLuck;
                winImportantContests -= contestByLuck;
            } else {
                luckBalance -= luck * winImportantContests;
                luckBalance += luck * (contestByLuck - winImportantContests);
                winImportantContests = 0;
            }
        }
        return luckBalance;
    }

    public static void main(String... args) {
        int[][] x = {
                {5, 1},
                {2, 1},
                {1, 1},
                {8, 1},
                {10, 0},
                {5, 0}
        };
        System.out.println("Expect is 29, result is " + luckBalance(3, x));
    }
}
