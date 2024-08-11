import java.sql.SQLOutput;

public class ValidPalindrome {
    public static boolean isPalindrome(String s){

        //s = "A man, a plan, a canal: Panama"
        //trim the string
        //remove the numeric/symbols
        // convert to lowercase
        // check the final string using 2 pointers --> start and end

        StringBuilder stringBuilder = new StringBuilder();
        String trimmedS = s.trim().toLowerCase();

        if(trimmedS.isEmpty()){
            return true;
        }
        char[] chars = trimmedS.toCharArray();

        for(int i = 0; i<trimmedS.toCharArray().length ; i++){
            if(isLetterOrDigit((chars[i]))){
                stringBuilder.append(chars[i]);
            }
        }
        int start = 0;
        int end = stringBuilder.length() - 1;

        while(start < end){
            if(stringBuilder.charAt(start) != stringBuilder .charAt(end)){
                return false;
            }else {
                start++;
                end --;
            }
        }
        return true;
    }

    public static boolean isLetterOrDigit(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String s = " apG0i4maAs::sA0m4i0Gp0";
        System.out.println("The string is palindrome : "+isPalindrome(s));
    }
}
