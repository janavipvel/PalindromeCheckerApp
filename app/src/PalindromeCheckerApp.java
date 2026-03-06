import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeCheckerApp {

    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }
            while (deque.size() > 1) {
                if (!deque.pollFirst().equals(deque.pollLast())) {
                    return false;
                }
            }
            return true;
        }
    }

    static class StringBuilderStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            String reversed = new StringBuilder(input).reverse().toString();
            return input.equals(reversed);
        }
    }

    static class PalindromeChecker {
        private PalindromeStrategy strategy;

        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String input) {
            return strategy.check(input);
        }
    }

    static void benchmark(String name, PalindromeStrategy strategy, String input) {
        long start = System.nanoTime();
        boolean result = strategy.check(input);
        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Strategy        : " + name);
        System.out.println("Input           : " + input);
        System.out.println("Is Palindrome?  : " + result);
        System.out.println("Execution Time  : " + duration + " ns");
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        String input = "level";

        benchmark("StackStrategy", new StackStrategy(), input);
        benchmark("DequeStrategy", new DequeStrategy(), input);
        benchmark("StringBuilderStrategy", new StringBuilderStrategy(), input);
    }
}