package br.com.vfs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ChallengerThree {

    static int test(final int[] a){

        int p = 1;
        int q = 2;

        TreeMap<Integer, Integer> values = new TreeMap<>();

        values.put(a[1], 1);
        values.put(a[2], 2);
        values.put(a[3], 3);
        /*
            0 1 2 3 4 5
            5 2 4 6 3 7

        [{2, 1}, {4, 2}, {6, 3}]
       3 -> [{2, 1}, {3, 4}, {4, 2}]


       1 4 2
       4-1  > 1

         */

        for(int i = 4; i <a.length-1; i++) {
            Integer last = values.lastKey();
            if (a[i] < last) {
                values.put(a[i], i);
                values.remove(last);
            }
        }

        List<Integer> positions = new ArrayList<>(values.values());
        int i = positions.get(0) - positions.get(1);

//        if(calcDist(positions.get(0),positions.get(1)) > 1){
//            return aux.
//        }
//
//        if(calcDist(positions.get(0),positions.get(2)) > 1){
//            return values.firstKey();
//        }


        return 0;
    }

    static int calcDist(int posOne, int posTwo){
        int i = posOne - posTwo;
        if (i < 0) return  -1*i;
        return i;
    }


//    public static void main(String... args){
//        System.out.println(test("50552"));
//    }
}
