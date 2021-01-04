package br.com.vfs.sorting;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FraudulentActivityNotifications {

//    class Median {
//        private int totalSize;
//        private int mapSize;
//        private boolean oddNumber;
//        private double[] medianValues;
//        private Map<Integer, Integer> minorElements;
//        private Map<Integer, Integer> majorElements;
//
//        public Median(int totalSize) {
//            this.totalSize = totalSize;
//            this.mapSize = mapSize/2;
//            this.oddNumber = !(mapSize % 2 == 0);
//            this.medianValues = oddNumber ? new double[1] : new double[2];
//            this.minorElements = new TreeMap<>();
//            this.majorElements = new TreeMap<>();
//        }
//
//        public double medianSortedList(){
//            return ;
//        }
//
//    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        final List<Integer> sortedList = new ArrayList<>();
        int initialDays = 1;
        int notifications = 0;
        for (int pos = 0; pos < expenditure.length; pos++) {
            int amountSpend = expenditure[pos];
            if(initialDays > d){
                double median = medianSortedList(sortedList);
               if (amountSpend >= 2*median) notifications++;
                removeSortedList(sortedList, expenditure[pos-d]);
            } else {
                initialDays++;
            }
            insertSortedListBase(sortedList, amountSpend);

//            errorPrint(sortedList);

        /*
        xxxxx mediana xxxx

        3 12 34 67 100 <- 34
        3 12 34 67 99 100  <- 34+6/27
         */
        }
        return notifications;
    }

    private static void errorPrint(List<Integer> sortedList) {
        sortedList.forEach(v-> System.out.print(v+" "));
        System.out.println();
        if(sortedList.size() < 2) return;
        for (int pos = 1; pos < sortedList.size(); pos++){
            if (sortedList.get(pos) < sortedList.get(pos-1)){
                throw new RuntimeException();
            }
        }
    }

    public static double medianSortedList(List<Integer> list){
        int size = list.size();
        int posMedian = size/2;
        if(size % 2 == 0) {
            return (list.get(posMedian)+list.get(posMedian-1))/2.0;
        }
        return list.get(posMedian);
    }

    /*
    64 143 137 68 67 49 86 151 65 72 187 119 56

64
64 143
64 137 143  <<-- 1 next = 0
64 68 137 143 <<-- 2 next = 1 ->  1 next = 0
64 67 68 137 143
49 64 67 68 137 143
49 64 67 68 86 137 143
49 64 67 68 86 137 143 151
49 64 65 67 68 86 137 143 151
49 64 65 67 68 72 86 137 143 151
49 64 65 67 68 72 86 137 143 151 187
0
49 64 65 67 68 72 86 119 137 143 151 187
<<-- 6 next 3
 86 > 56 = SIM
<<-- 3 next 1
67 > 56 = SIM
<<-- 2 next 0
65 > 56
49 64 56 65 67 68 72 86 119 137 143 151 187

    49 64 56 65 67 68 72 86 119 137 143 151 187

     */

    public static void insertSortedListBase(List<Integer> list, int element){
        if(list.isEmpty() || list.get(0) > element){
            list.add(0, element);
        } else if(list.get(list.size()-1) <= element){
            list.add(element);
        } else {
            int initialPos = list.size()/2;
            insertSortedList(list, element, initialPos, initialPos/2);
        }
    }

    public static void insertSortedList(List<Integer> list, int element, int pos, int next){
        if(next == 0) {
            if(list.get(pos) >= element) {
                if(list.get(pos-1) > element){
                    insertSortedList(list, element, pos-1, 0);
                } else {
                    list.add(pos, element);
                }
                list.add(pos, element);
            } else {
                if(list.get(pos+1) < element){
                    insertSortedList(list, element, pos+1, 0);
                } else {
                    list.add(pos+1, element);
                }

            }
        } else{
            if(list.get(pos).equals(element)){
                list.add(pos, element);
                return;
            }
            int nextAux = next/2; //(next%2 == 0) ? next/2 : (next/2)+1;
            if(list.get(pos) > element) {
                insertSortedList(list, element, pos-next, nextAux);
            } else {
                insertSortedList(list, element, pos+next, nextAux);
            }
        }
//
//        boolean notInsert = true;
//        for(int pos = 0; pos < list.size(); pos++){
//            if(list.get(pos) >= element) {
//               list.add(pos, element);
//               notInsert = false;
//               break;
//            }
//        }
//        if (notInsert) list.add(element);
    }

    public static void removeSortedList(List<Integer> list, Integer element){
        list.remove(element);
    }

    public static void main(String... args) throws IOException {
//        int[] i = {1, 2, 3, 4, 4};
//        System.out.println("Expect is 0, result is "+activityNotifications(i, 4));
//        int[] x = {10, 20, 30, 40, 50};
//        System.out.println("Expect is 1, result is "+activityNotifications(x, 3));
//        int[] y = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//        System.out.println("Expect is 2, result is "+activityNotifications(y, 5));

        FileInputStream inputStream = new FileInputStream("/home/vinicius/estudo/hacker-rank/src/main/java/br/com/vfs/sorting/test.txt");
        try {
            String texto = IOUtils.toString(inputStream, Charset.defaultCharset());
            List<Integer> collect = Arrays.stream(texto.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            int a[] = new int[collect.size()];
            for (int pos = 0; pos < collect.size(); pos++) {
                a[pos] = collect.get(pos);
            }
            System.out.println("Expect is 770, result is "+activityNotifications(a, 9999));

        } finally {
            inputStream.close();
        }
    }
}