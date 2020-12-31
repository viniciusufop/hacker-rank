package br.com.vfs.sorting;

import java.util.Comparator;
import java.util.List;

public class SortingComparator {

    static class Player {
        String name;
        int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }
    static class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {
            if (a.score > b.score) return -1;
            if (a.score < b.score) return 1;
            int minLength = Math.min(a.name.length(), b.name.length());
            for (int pos = 0; pos < minLength; pos++){
                if(a.name.charAt(pos) > b.name.charAt(pos)) return 1;
                if(a.name.charAt(pos) < b.name.charAt(pos)) return -1;
            }
            if (a.name.length() == b.name.length()) return 0;
            return a.name.length() > b.name.length() ? 1 : -1;
        }
    }

    public static void main(String... args) {
        System.out.println("Expect is \n" +
                "    aleksa 150\n" +
                "    amy 100\n" +
                "    david 100\n" +
                "    aakansha 75\n" +
                "    heraldo 50" +
                ", result is ");
        List<Player> players = List.of(
                new Player("amy", 100),
                new Player("david", 100),
                new Player("heraldo", 50),
                new Player("aakansha", 75),
                new Player("aleksa", 150));
        players.stream()
                .sorted(new Checker())
                .forEach(System.out::println);

        System.out.println("Expect is \n" +
                "        ba 9\n" +
                "        cb 9\n" +
                "        aab 8\n" +
                "        ab 8\n" +
                "        ab 8\n" +
                "        b 8\n" +
                "        cbb 8\n" +
                "        ccb 8\n" +
                "        bb 7\n" +
                "        b 6\n" +
                "        bca 6\n" +
                "        ccc 4\n" +
                "        b 3\n" +
                "        b 3\n" +
                "        bb 3\n" +
                "        bb 3\n" +
                "        bb 2\n" +
                "        bbb 2\n" +
                "        a 1\n" +
                "        bba 0" +
                ", result is ");
        List<Player> players2 = List.of(
                new Player("b", 3),
                new Player("a", 1),
                new Player("bb", 3),
                new Player("b", 8),
                new Player("bba", 0),
                new Player("bb", 2),
                new Player("bca", 6),
                new Player("ccc", 4),
                new Player("b", 3),
                new Player("ab", 8),
                new Player("bb", 3),
                new Player("bb", 7),
                new Player("ccb", 8),
                new Player("bbb", 2),
                new Player("aab", 8),
                new Player("b", 6),
                new Player("ab", 8),
                new Player("cb", 9),
                new Player("cbb", 8),
                new Player("ba", 9));
        players2.stream()
                .sorted(new Checker())
                .forEach(System.out::println);
    }
}
