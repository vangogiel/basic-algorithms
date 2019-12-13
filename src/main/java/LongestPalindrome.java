public class LongestPalindrome {

    public static void main(String args[]) {
        System.out.println(longestPalindrome("babadaba"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String subject = s.substring(i,j);
                if (isPalindrome(subject) && subject.length() > longestPalindrome.length()) {
                    longestPalindrome = subject;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}