package br.com.vfs.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        /*
        - ordena a lista de maquinas
        2, 3, 4, 5, 6, 7, 8



         */


        long maxDay = 0;
        Map<Long, Long> machinesByDays = new HashMap<>();
        for (long machine : machines) {
            machinesByDays.compute(machine, (k, v) -> v == null ? 1 : ++v);
            if(machine > maxDay) maxDay = machine;
        }
        long calProdMaxDay = produceInDay(maxDay, machinesByDays);

        long x = goal < calProdMaxDay ? 0 : goal / calProdMaxDay ;

        long days = x;
        long cal = 0;
        while (cal < goal){
            days++;
            cal = produceInDay(days, machinesByDays);

        }
        return days;
    }

    static long produceInDay(long dayX, Map<Long, Long> machinesByDays){
        long cal = 0;
        for (Map.Entry<Long, Long> machine: machinesByDays.entrySet()) {
            cal += (dayX/machine.getKey()) * machine.getValue();
        }
        return cal;
    }

    public static void main(String... args) {
        long[] values = {4, 5, 6};
        System.out.println("Expect is 20, result is " + minTime(values, 12));
    }
}
