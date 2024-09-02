import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueStrings = new HashSet<>();
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        int max = 0;

        while(windowEnd < n){
            if(!uniqueStrings.contains(s.charAt(windowEnd))){
                uniqueStrings.add(s.charAt(windowEnd));
                windowEnd++;
                max = Math.max(uniqueStrings.size(),max);
            }else{
                uniqueStrings.remove(s.charAt(windowStart));
                windowStart++;
            }

        }
        return max;
    }

    public int lengthOfLongestSubstringV2(String s) {
        if (s == null || s.isEmpty()) return 0;

        int stringLength = s.length();
        int longestSubstringLength = 0;
        int windowStart = 0;

        // This array will store the last seen position of each character
        int[] lastSeenAt = new int[128];  // Assuming ASCII characters

        // Initialize lastSeenAt with -1 to indicate no character has been seen yet
        for (int i = 0; i < 128; i++) {
            lastSeenAt[i] = -1;
        }

        for (int windowEnd = 0; windowEnd < stringLength; windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // If we've seen this character before, move the window start
            // to the position after where we last saw this character
            if (lastSeenAt[currentChar] >= windowStart) {
                windowStart = lastSeenAt[currentChar] + 1;
            }

            // Update the last seen position of the current character
            lastSeenAt[currentChar] = windowEnd;

            // Calculate the current substring length and update longest if necessary
            int currentSubstringLength = windowEnd - windowStart + 1;
            longestSubstringLength = Math.max(longestSubstringLength, currentSubstringLength);
        }

        return longestSubstringLength;
    }

    public static void main(String[] args){
        LongestSubstring solution = new LongestSubstring();
        String s = "abcabcbab";
        System.out.println("length of the longest substring without repeating characters is "+solution.lengthOfLongestSubstring(s));
    }
}
