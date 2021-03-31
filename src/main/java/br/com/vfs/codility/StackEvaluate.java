package br.com.vfs.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackEvaluate {
    static int solution(String S) {
        Stack stack = new Stack();
        try {
            Arrays.stream(S.split("\\ ")).forEach(stack::execute);
            return stack.topmost();
        } catch (RuntimeException ex) {
            return -1;
        }
    }

    static class Stack {
        List<Integer> elements = new ArrayList<>();

        void execute(String command) {
            switch (command.toUpperCase()) {
                case "+": {
                    plus();
                    break;
                }
                case "-": {
                    minus();
                    break;
                }
                case "POP": {
                    pop();
                    break;
                }
                case "DUP": {
                    dup();
                    break;
                }
                default:
                    push(Integer.parseInt(command));
            }
        }

        Integer topmost() {
            if (elements.isEmpty()) throw new RuntimeException("Empty list.");
            return elements.get(elements.size() - 1);
        }

        private void push(Integer element) {
            elements.add(element);
        }

        private void plus() {
            if (elements.size() < 2)
                throw new RuntimeException("Invalid command, because there is not two elements in the stack.");
            Integer newElement = elements.remove(elements.size() - 1) + elements.remove(elements.size() - 1);
            if (newElement > 1048575) throw new RuntimeException("Invalid command, because the result is invalid.");
            push(newElement);
        }

        private void minus() {
            if (elements.size() < 2)
                throw new RuntimeException("Invalid command, because there is not two elements in the stack.");
            Integer newElement = elements.remove(elements.size() - 1) - elements.remove(elements.size() - 1);
            if (newElement < 0) throw new RuntimeException("Invalid command, because the result is invalid.");
            push(newElement);
        }

        private void pop() {
            if (elements.isEmpty()) throw new RuntimeException("Empty list.");
            elements.remove(elements.size() - 1);
        }

        private void dup() {
            if (elements.isEmpty()) throw new RuntimeException("Empty list.");
            push(elements.get(elements.size() - 1));
        }
    }

    public static void main(String... args) {
        System.out.println(solution("4 5 6 - 7 +"));
        System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -"));
        System.out.println(solution("5 6 + -"));
        System.out.println(solution("3 DUP 5 - -"));
    }
}
