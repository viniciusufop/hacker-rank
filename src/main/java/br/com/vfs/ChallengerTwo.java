package br.com.vfs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ChallengerTwo {

    static int test(final String phrase){
        Map<Character, Integer> control = new HashMap<>();
        for (char c : phrase.toCharArray()){
            control.compute(c, (k, v) -> v == null ? 1 : ++v);
        }
        int delete = 0;
        Set<Integer> onlyTimes = new TreeSet<>(new IntegerComparatorDesc());
        for (int value: control.values().stream().sorted().collect(Collectors.toList())){
            if(!onlyTimes.contains(value)){
                onlyTimes.add(value);
            } else {
                int removeOne = 1;
                boolean addInOnlyTimes = false;
                while (removeOne <= value){
                    if(!onlyTimes.contains(value-removeOne)){
                        onlyTimes.add(value-removeOne);
                        delete += removeOne;
                        addInOnlyTimes = true;
                        break;
                    }
                    removeOne++;
                }
                if(!addInOnlyTimes) delete += value;
            }
        }
        return delete;
    }

    static class IntegerComparatorDesc implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return y.compareTo(x);
        }
    }

    public static void main(String... args){
        System.out.println(test("50552"));
    }
}
