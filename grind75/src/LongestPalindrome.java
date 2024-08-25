import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome{
    public int longestPalindrome(String s) {
        Set<Character> seen = new HashSet<>();
        char[] chars = s.toCharArray();
        int palindromeLength = 0;
        for(char c : chars){
            if(seen.contains(c)) {
                palindromeLength += 2;
                seen.remove(c);
            }else{
                seen.add(c);
            }
        }
        return !seen.isEmpty() ? palindromeLength + 1 : palindromeLength;
    }

    public static void main(String[] args) {
        String s = "aaabbb";
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println("Length of the longest palindrome is " +solution.longestPalindrome(s));
    }
}
