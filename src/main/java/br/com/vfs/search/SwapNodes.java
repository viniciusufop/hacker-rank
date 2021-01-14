package br.com.vfs.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] prints = new int[queries.length][indexes.length];
        Node root = new Node (1, 1, indexes[0][0],indexes[0][1], indexes);
        int query = 0;
        for (int k : queries){
            root.swap(k);
            List<Integer> print = new ArrayList<>();
            int[] result = new int[indexes.length];
            root.print(print);
            int pos = 0;
            for (int value: print) {
                result[pos] = value;
                pos++;
            }
            prints[query] = result;
            query++;
        }
        return prints;
    }

    static class Node {
        int value;
        int depth;
        Node left;
        Node right;

        public Node(int value, int depth, int left, int right, int[][] indexes) {
            this.value = value;
            this.depth = depth;
            if(left != -1) {
                this.left = new Node(left,depth+1, indexes[left-1][0], indexes[left-1][1], indexes);
            }
            if(right != -1) {
                this.right = new Node(right,depth+1, indexes[right-1][0], indexes[right-1][1], indexes);
            }
        }

        void swap(int k){
            if(depth % k == 0) {
                Node aux = this.left;
                this.left = right;
                this.right = aux;
            }
            if(left != null) left.swap(k);
            if(right != null) right.swap(k);
        }

        void print(List<Integer> result){
            if(left != null) left.print(result);
            result.add(value);
            if(right != null) right.print(result);
        }
    }


    public static void main(String... args) {

        System.out.println("Expect is \n" +
                "3 1 2 \n" +
                "2 1 3 \n" +
                ", result is ");
        int[][] ints = swapNodes(new int[][]{{2, 3}, {-1, -1}, {-1, -1}}, new int[]{1, 1});
        Arrays.stream(ints)
                .forEach(a -> System.out.println(Arrays.toString(a)));

    }

}
