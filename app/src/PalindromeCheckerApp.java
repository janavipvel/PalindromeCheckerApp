public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        String word = "madam1";
        boolean isPalindrome = true;
        int n = word.length() - 1;
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(n - i)) {
                isPalindrome = false;
                break;
            }

        }
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }

    }
}
