import java.util.*;

public class PalindromeCheckerApp {

    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(normalized))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}