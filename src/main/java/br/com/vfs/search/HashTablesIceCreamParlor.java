package br.com.vfs.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashTablesIceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        final Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int pos = 0; pos < cost.length; pos ++){
            List<Integer> integers = map.getOrDefault(cost[pos], new ArrayList<>());
            integers.add(pos +1);
            map.put(cost[pos], integers);
        }

        if(money % 2 == 0 && map.getOrDefault(money/2, new ArrayList<>()).size() > 1){
            List<Integer> positions = map.get(money/2);
            if(positions.get(0) > positions.get(1)) {
                System.out.println(positions.get(1) + " " + positions.get(0));
            } else {
                System.out.println(positions.get(0) + " " + positions.get(1));
            }
            return;
        }

        for (int costOfFlavor : map.keySet()){
            if(costOfFlavor >= money) break;
            int otherFlavor = money - costOfFlavor;
            List<Integer> others = map.get(otherFlavor);
            if (others != null) {
                List<Integer> positions = map.get(costOfFlavor);
                if(positions.get(0) > others.get(0)) {
                    System.out.println(others.get(0) + " " + positions.get(0));
                } else {
                    System.out.println(positions.get(0) + " " + others.get(0));
                }
                break;
            }
        }
    }


    public static void main(String... args) {
        System.out.println("Expect is 1 4, result is ");
        whatFlavors(new int[]{1, 4, 5, 3, 2}, 4);
        System.out.println("Expect is 1 2, result is ");
        whatFlavors(new int[]{2, 2, 4, 3}, 4);
    }
}
