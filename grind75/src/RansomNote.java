public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean canConstruct = true;
        int[] occurrences = new int[26];
        char[] ransomNoteCharacters = ransomNote.toCharArray();
        char[] magazineCharacters = magazine.toCharArray();

        for(int i = 0 ; i<ransomNoteCharacters.length ; i++){
            occurrences[ransomNoteCharacters[i]- 'a']++;
        }

        for(int i = 0 ; i<magazineCharacters.length ; i++){
            occurrences[magazineCharacters[i]- 'a']--;
        }

        for(int i = 0;i<occurrences.length;i++){
            if(occurrences[i] > 0 ){
                return false;
            }
        }
        return canConstruct;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("Can construct "+solution.canConstruct(ransomNote,magazine));
    }
}

