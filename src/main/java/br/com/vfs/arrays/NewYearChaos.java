package br.com.vfs.arrays;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        boolean tooChaotic = false;
        int bribes = 0;
        int pos = 0;
        while (pos < q.length){
            int value = q[pos];
            int aux = (value-1)-pos;
            if(aux > 2) {
                tooChaotic = true;
                break;
            }
            pos++;
            if(aux < 0) continue;
            bribes += aux;
        }
        if(tooChaotic){
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }

    public static void main(String... args) {
//        int[] values = {2, 1, 5, 3, 4};
        /*
        1-2 = -1
        5-1 = 4
        3-5 = -2
        4-3 = 1
         */
//        System.out.println("Expect is 3");
//        minimumBribes(values);
//        int[] values2 = {2, 5, 1, 3, 4};
//        System.out.println("Expect is Too chaotic");
//        minimumBribes(values2);
        /*

        {1, 2, 5, 3, 7, 8, 6, 4};

        value posA posC
        5 2 4           4-2 = 2
        3 3 2           2-3 = -1
        7 4 6           6-4 = 2
        8 5 7           7-5 = 2
        6 6 5           5-6 = -1
        4 7 3           3-7 = -4

        value-1-pos;
        5-1-2   = 2
        3-1-3   = -1
        7-1-4   = 2
        8-1-5   = 2
        6-1-6   = -1
        4-1-7   = -4

        {1, 2, 3, 4, 5, 6, 7, 8};
        {1, 2, 3, 5, 4, 6, 7, 8};
        {1, 2, 3, 5, 4, 7, 6, 8};
        {1, 2, 3, 5, 4, 7, 8, 6};
        {1, 2, 3, 5, 7, 4, 8, 6};
        {1, 2, 3, 5, 7, 8, 4, 6};
        {1, 2, 5, 3, 7, 8, 4, 6};

        {1, 2, 3, 4, 5, 6, 7, 8};


        {1, 2, 5, 3, 7, 8, 6, 4};
        {1, 2, 5, 4, 7, 8, 6, 3}; +4
        {1, 2, 3, 4, 7, 8, 6, 5}; +5
        {1, 2, 3, 4, 5, 8, 6, 7}; +5
         */



        int[] values3 = {1, 2, 5, 3, 7, 8, 6, 4};
        System.out.println("Expect is 7");
        minimumBribes(values3);
    }
}
