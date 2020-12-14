package br.com.vfs.warm_up;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long length = s.length();
        long multiple = n / length;
        long count = countRepeatedLetterAInString(s);
        count *= multiple;
        return count + countRepeatedLetterAInString(s.substring(0, Long.valueOf(n % length).intValue()));
    }

    static long countRepeatedLetterAInString(final String value){
        long repeated = 0;
        for(int count = 0; count < value.length(); count++)
            if (value.charAt(count) == 'a')
                repeated++;
        return repeated;
    }


    public static void main(String... args) {
        System.out.println("Expect is 1000000000000, result is " + repeatedString("a", 1000000000000L));
    }
}
