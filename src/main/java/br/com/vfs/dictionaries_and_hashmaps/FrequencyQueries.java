package br.com.vfs.dictionaries_and_hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> mapperNumbers = new HashMap<>();
        Map<Integer, Integer> mapperCount = new HashMap<>();
        List<Integer> printCommand  = new ArrayList<>();
        int count;
        int newCount;
        //processar a lista de query
        for (List<Integer> query : queries){
            //valor
            switch (query.get(0)){
                case 1:
                    count = mapperNumbers.getOrDefault(query.get(1), 0);
                    newCount = count+1;
                    mapperNumbers.put(query.get(1), newCount);
                    mapperCount.compute(count, (k, v) -> v == null ? 0 : --v);
                    mapperCount.compute(newCount, (k, v) -> v == null ? 1 : ++v);
                    break;
                case 2:
                    count = mapperNumbers.getOrDefault(query.get(1), 0);
                    if(count > 0){
                        newCount = count-1;
                        mapperNumbers.put(query.get(1), newCount);
                        mapperCount.compute(count, (k, v) -> v == null ? 0 : --v);
                        mapperCount.compute(newCount, (k, v) -> v == null ? 1 : ++v);
                    }
                    break;
                case 3:
                    if(mapperCount.getOrDefault(query.get(1), 0) > 0)
                        printCommand.add(1);
                    else
                        printCommand.add(0);
            }
        }

        return printCommand;
    }

    public static void main(String... args) {
        ArrayList<List<Integer>> commands = new ArrayList<>();
        commands.add(List.of(1, 5));
        commands.add(List.of(1, 6));
        commands.add(List.of(3, 2));
        commands.add(List.of(1, 10));
        commands.add(List.of(1, 10));
        commands.add(List.of(1, 6));
        commands.add(List.of(2, 5));
        commands.add(List.of(3, 2));


        System.out.println("Expect is 0 and 1, result is ");
        freqQuery(commands).forEach(System.out::println);
    }
}
