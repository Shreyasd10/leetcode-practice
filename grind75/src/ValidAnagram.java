import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s,String t){
        //s = "anagram", t = "nagaram"

        Map<Character,Integer> occurrences = new HashMap<>();

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        for(char c : charsS){
            occurrences.put(c,occurrences.getOrDefault(c,0) + 1);
        }

        for(char c : charsT){
            occurrences.put(c,occurrences.getOrDefault(c,0) - 1);
        }

        for(int occurrence : occurrences.values()){
            if(occurrence != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramV2(String s,String t){
        //s = "anagram", t = "nagaram"
        if(s.length() != t.length()) return false;
        int[] occurrences = new int[26];
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        for (char value : charsS) {
            occurrences[value - 'a']++;
        }
        for (char c : charsT) {
            occurrences[c - 'a']--;
        }

        for (int occurrence : occurrences) {
            if (occurrence != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cat";
        String t = "rac" ;
        System.out.println("The Strings are anagram "+isAnagramV2(s,t));
    }
}
