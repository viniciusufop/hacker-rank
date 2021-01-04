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

    static class Median {
        private int totalSize;
        private Map<Integer, Integer> elements;

        public Median(int totalSize, List<Integer> initialElements) {
            this.totalSize = totalSize;
            this.elements = new TreeMap<>();
            initialElements.forEach(e -> elements.compute(e, (k, v) -> v == null ? 1 : ++v));
        }

        public void actualizeElement(int remove, int include){
            elements.computeIfPresent(remove, (k, v) -> --v);
            elements.compute(include, (k, v) -> v == null ? 1 : ++v);
        }

        public double medianSortedList(){
            if(totalSize % 2 == 0){
                int posOne = totalSize/2;
                int posTwo = posOne + 1;
                boolean getPosOne = false;
                int valuePosOne = 0;
                int valuePosTwo = 0;
                int aux = 0;
                for (int e: elements.keySet()) {
                    aux += elements.get(e);
                    if(aux >= posOne && !getPosOne) {
                        getPosOne = true;
                        valuePosOne = e;
                    }
                    if(aux >= posTwo) {
                        valuePosTwo = e;
                        break;
                    }
                }
                return (valuePosOne+valuePosTwo)/2.0;
            }
            else {
                int pos = totalSize/2 + 1;
                int valuePos = 0;
                int aux = 0;
                for (int e: elements.keySet()) {
                    aux += elements.get(e);
                    if(aux >= pos) {
                        valuePos = e;
                        break;
                    }
                }
                return valuePos;
            }
        }
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        List<Integer> initial = new ArrayList<>();
        for (int pos = 0; pos < d; pos++){
            initial.add(expenditure[pos]);
        }

        final Median medianObj = new Median(d, initial);
        int notifications = 0;

        for (int pos = d; pos < expenditure.length; pos++) {
            int amountSpend = expenditure[pos];
            double median = medianObj.medianSortedList();
            if (amountSpend >= 2*median) notifications++;
            medianObj.actualizeElement(expenditure[pos-d], amountSpend);
        }
        return notifications;
    }

    public static void main(String... args) throws IOException {
        int[] i = {1, 2, 3, 4, 4};
        System.out.println("Expect is 0, result is "+activityNotifications(i, 4));
        int[] x = {10, 20, 30, 40, 50};
        System.out.println("Expect is 1, result is "+activityNotifications(x, 3));
        int[] y = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        System.out.println("Expect is 2, result is "+activityNotifications(y, 5));

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