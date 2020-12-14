package br.com.vfs.warm_up;

import java.util.HashMap;
import java.util.Map;

public class SalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        final Map<Integer, Integer> totalSockByColor = new HashMap<>();

        for (int count = 0; count < n; count++){
            totalSockByColor.compute(ar[count], (key, value) -> value == null ? 1 : ++value);
        }

        return totalSockByColor.values()
                .stream()
                .map(countSock -> countSock/2)
                .reduce(Integer::sum)
                .orElse(0);
    }


    public static void main(String... args) {
        int[] values = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println("Expect is 3, result is " + sockMerchant(9, values));
    }
}
