package br.com.vfs.sorting;

import java.util.HashMap;
import java.util.Map;

public class MergeSortCountingInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return sort(arr, 0, arr.length-1);
    }

    private static long sort(int[] array, int indiceInicio, int indiceFim) {
        // Condicional que verifica a validade dos parâmetros passados.
        if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 &&
                indiceFim < array.length && array.length != 0) {
            int meio = ((indiceFim + indiceInicio) / 2);

            long swap1 = sort(array, indiceInicio, meio);
            long swap2 = sort(array, meio + 1, indiceFim);
            long swap3 = merge(array, indiceInicio, meio, indiceFim);
            return swap1 + swap2 + swap3;
        }
        return 0L;
    }

    private static long merge(int[] array, int indiceInicio, int meio, int indiceFim) {
        long swap = 0;
        Map<Integer, Integer> auxiliar = new HashMap<>();
        //Copiando o trecho da lista que vai ser ordenada
        for (int i = indiceInicio; i <= indiceFim; i++) {
            auxiliar.put(i, array[i]);
        }
        //Índices auxiliares
        int i = indiceInicio;
        int j = meio + 1;
        int k = indiceInicio;

        //Junção das listas ordenadas
        while (i <= meio && j <= indiceFim) {
            if (auxiliar.get(i) <= auxiliar.get(j)) {
                array[k] = auxiliar.get(i);
                i++;
            } else {
                array[k] = auxiliar.get(j);
                swap += j-k;
                j++;
            }
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (i <= meio) {
            array[k] = auxiliar.get(i);
            i++;
            k++;
        }

        //Append de itens que não foram usados na Junção
        while (j <= indiceFim) {
            array[k] = auxiliar.get(j);
            j++;
            k++;
        }
        return swap;
    }
    public static void main(String... args){
        int[] i = {2, 1, 3, 1, 2};
        System.out.println("Expect is 4, result is " + countInversions(i));
    }
}