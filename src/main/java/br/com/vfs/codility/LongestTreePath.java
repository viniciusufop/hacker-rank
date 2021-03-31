package br.com.vfs.codility;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;

public class LongestTreePath {
    static int solution(Tree T) {
        return longestDistinctPath(new HashSet<>(), T);
    }

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    static Integer longestDistinctPath(Set<Integer> parentPath, Tree T) {
        if (T == null || parentPath.contains(T.x)) {
            return 0;
        }
        parentPath.add(T.x);
        int left = longestDistinctPath(parentPath, T.l);
        int right = longestDistinctPath(parentPath, T.r);
        parentPath.remove(T.x);
        return max(left, right) + 1;
    }

    public static void main(String... args) {
        System.out.println(solution(new Tree()));
    }
}
